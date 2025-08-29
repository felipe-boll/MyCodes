// Salve este arquivo como "app.js", depois rode:
//   npm init -y && npm i express
//   node app.js
// e abra http://localhost:3000

const express = require('express');
const app = express();
app.use(express.json({ limit: '1mb' }));

// --- Banco "em memória" (apenas para demo/MVP) ---
// Estrutura: store[songId][wordIndex] = note
const store = Object.create(null);

// Página única com HTML + CSS + JS embutidos
const page = `<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Letras com Notas — MVP</title>
  <style>
    :root { --bg:#0b0d10; --panel:#141821; --muted:#7b8799; --text:#e6edf3; --accent:#5dd4ff; --line:#263043; }
    * { box-sizing: border-box; }
    body { margin: 0; font-family: system-ui, -apple-system, Segoe UI, Roboto, Ubuntu, 'Helvetica Neue', Arial, 'Noto Sans', 'Apple Color Emoji', 'Segoe UI Emoji'; background: var(--bg); color: var(--text); }
    header { padding: 20px; border-bottom: 1px solid var(--line); background: var(--panel); position: sticky; top: 0; z-index: 10; }
    header h1 { margin: 0; font-size: 18px; letter-spacing: .3px; }
    main { max-width: 960px; margin: 24px auto; padding: 0 16px 64px; display: grid; gap: 16px; }

    .card { background: var(--panel); border: 1px solid var(--line); border-radius: 12px; padding: 16px; }
    .row { display: grid; grid-template-columns: 1fr 1fr; gap: 16px; }
    @media (max-width: 800px) { .row { grid-template-columns: 1fr; } }

    textarea { width: 100%; min-height: 160px; background: #0f131a; color: var(--text); border: 1px solid var(--line); border-radius: 10px; padding: 12px; resize: vertical; line-height: 1.6; }
    .controls { display: flex; gap: 10px; align-items: center; flex-wrap: wrap; margin-top: 12px; }
    button { background: var(--accent); color: #001018; border: 0; padding: 10px 14px; border-radius: 10px; font-weight: 600; cursor: pointer; }
    button.secondary { background: transparent; color: var(--text); border: 1px solid var(--line); }
    .hint { color: var(--muted); font-size: 12px; }

    .lyricsView { background:#0f131a; border:1px solid var(--line); border-radius:12px; padding:16px; min-height: 220px; line-height: 2.1; font-size: 18px; }
    .word { position: relative; display: inline-block; padding: 0 2px; border-radius: 6px; cursor: pointer; }
    .word:hover { background: rgba(93,212,255,0.08); }
    .word.has-note { background: rgba(93,212,255,0.12); outline: 1px dashed rgba(93,212,255,0.4); }
    .note-badge { position: absolute; top: -1.35em; left: 0; font-size: 12px; padding: 0 4px; border-radius: 6px; border: 1px solid var(--line); background: #0b0f16; color: var(--accent); white-space: nowrap; transform: translateY(-2px); }

    .popup { position: absolute; z-index: 20; display: none; background:#0b0f16; border:1px solid var(--line); border-radius: 12px; padding: 10px; box-shadow: 0 8px 30px rgba(0,0,0,.35); min-width: 220px; }
    .popup label { display:block; font-size:12px; color: var(--muted); margin-bottom:6px; }
    .popup input { width: 100%; padding: 8px 10px; border-radius: 8px; border:1px solid var(--line); background:#0f131a; color: var(--text); }
    .popup .row-actions { display:flex; gap:8px; margin-top:8px; }

    .footer { text-align:center; color: var(--muted); font-size: 12px; }
    code.kbd { background:#0f131a; border:1px solid var(--line); padding:2px 6px; border-radius:6px; }
  </style>
</head>
<body>
  <header>
    <h1>🎼 Letras com Notas — protótipo full-stack (1 arquivo)</h1>
  </header>
  <main>
    <div class="row">
      <section class="card">
        <h2 style="margin-top:0">1) Escreva/cole a letra</h2>
        <textarea id="lyricsInput" placeholder="Cole a letra aqui. Use quebras de linha normalmente.\nEx.:\nEu sei que vou te amar\nPor toda a minha vida eu vou te amar"></textarea>
        <div class="controls">
          <button id="renderBtn">Renderizar letra</button>
          <button id="clearBtn" class="secondary">Limpar</button>
          <span class="hint">Clique em uma <em>palavra</em> para adicionar/editar a <strong>nota</strong>.</span>
        </div>
      </section>
      <section class="card">
        <h2 style="margin-top:0">2) Visualização interativa</h2>
        <div id="lyricsView" class="lyricsView" aria-live="polite"></div>
      </section>
    </div>

    <section class="card">
      <h2 style="margin-top:0">Dica</h2>
      <p class="hint">A nota fica salva no servidor (em memória) por <code class="kbd">songId</code> derivado do texto da letra. Se você mudar a letra e clicar em <strong>Renderizar</strong>, um novo <code class="kbd">songId</code> será gerado.</p>
    </section>

    <p class="footer">Feito para TCC/MVP — sem banco persistente. Em produção, use PostgreSQL e autenticação.</p>
  </main>

  <!-- Popup -->
  <div id="popup" class="popup" role="dialog" aria-modal="true">
    <label for="noteInput">Nota (ex.: C, Dm, G7, F#m7(b5))</label>
    <input id="noteInput" type="text" placeholder="Ex.: G7" />
    <div class="row-actions">
      <button id="saveNoteBtn">Salvar</button>
      <button id="removeNoteBtn" class="secondary">Remover</button>
      <button id="cancelBtn" class="secondary">Cancelar</button>
    </div>
  </div>

  <script>
    // --- Util: gera um ID estável a partir da letra (SHA-256 -> hex) ---
    async function computeSongId(text) {
      const enc = new TextEncoder().encode(text.trim());
      const buf = await crypto.subtle.digest('SHA-256', enc);
      const bytes = Array.from(new Uint8Array(buf));
      return bytes.map(b => b.toString(16).padStart(2,'0')).join('');
    }

    const $lyricsInput = document.getElementById('lyricsInput');
    const $renderBtn = document.getElementById('renderBtn');
    const $clearBtn = document.getElementById('clearBtn');
    const $lyricsView = document.getElementById('lyricsView');

    const $popup = document.getElementById('popup');
    const $noteInput = document.getElementById('noteInput');
    const $saveNoteBtn = document.getElementById('saveNoteBtn');
    const $removeNoteBtn = document.getElementById('removeNoteBtn');
    const $cancelBtn = document.getElementById('cancelBtn');

    let songId = null;
    let currentWordEl = null;

    function closePopup() { $popup.style.display = 'none'; currentWordEl = null; }

    function openPopupForWord(wordEl) {
      currentWordEl = wordEl;
      const rect = wordEl.getBoundingClientRect();
      $popup.style.left = (rect.left + window.scrollX) + 'px';
      $popup.style.top = (rect.bottom + window.scrollY + 6) + 'px';
      $noteInput.value = wordEl.dataset.note || '';
      $popup.style.display = 'block';
      $noteInput.focus();
      $noteInput.select();
    }

    function setWordNote(wordEl, note) {
      wordEl.dataset.note = note;
      if (note && note.trim() !== '') {
        wordEl.classList.add('has-note');
        let badge = wordEl.querySelector('.note-badge');
        if (!badge) {
          badge = document.createElement('span');
          badge.className = 'note-badge';
          wordEl.appendChild(badge);
        }
        badge.textContent = note.trim();
      } else {
        wordEl.classList.remove('has-note');
        const badge = wordEl.querySelector('.note-badge');
        if (badge) badge.remove();
        delete wordEl.dataset.note;
      }
    }

    async function saveNoteToServer(index, note) {
      if (!songId) return;
      await fetch('/api/notes', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ songId, index, note })
      });
    }

    async function loadNotesFromServer() {
      if (!songId) return {};
      const res = await fetch('/api/notes?songId=' + songId);
      if (!res.ok) return {};
      const data = await res.json();
      return data.notes || {};
    }

    function clearView() { $lyricsView.innerHTML = ''; }

    async function renderLyrics() {
      clearView();
      const text = $lyricsInput.value || '';
      songId = await computeSongId(text);

      let globalIndex = 0;
      const lines = text.split(/\n/);
      for (const line of lines) {
        const lineFrag = document.createDocumentFragment();
        const tokens = line.split(/(\s+)/); // preserva espaços
        for (const t of tokens) {
          if (/^\s+$/.test(t)) { lineFrag.appendChild(document.createTextNode(t)); continue; }
          if (t.length === 0) continue;
          const span = document.createElement('span');
          span.className = 'word';
          span.dataset.index = String(globalIndex++);
          span.textContent = t;
          span.addEventListener('click', () => openPopupForWord(span));
          lineFrag.appendChild(span);
        }
        $lyricsView.appendChild(lineFrag);
        $lyricsView.appendChild(document.createElement('br'));
      }

      // após renderizar, carrega notas salvas
      const notes = await loadNotesFromServer();
      for (const [idx, note] of Object.entries(notes)) {
        const el = $lyricsView.querySelector('.word[data-index="' + idx + '"]');
        if (el) setWordNote(el, note);
      }
    }

    $renderBtn.addEventListener('click', renderLyrics);
    $clearBtn.addEventListener('click', () => { $lyricsInput.value=''; songId=null; clearView(); });

    $saveNoteBtn.addEventListener('click', async () => {
      if (!currentWordEl) return;
      const idx = Number(currentWordEl.dataset.index);
      const note = $noteInput.value.trim();
      setWordNote(currentWordEl, note);
      await saveNoteToServer(idx, note);
      closePopup();
    });

    $removeNoteBtn.addEventListener('click', async () => {
      if (!currentWordEl) return;
      const idx = Number(currentWordEl.dataset.index);
      setWordNote(currentWordEl, '');
      await saveNoteToServer(idx, '');
      closePopup();
    });

    $cancelBtn.addEventListener('click', closePopup);

    // Fecha popup ao clicar fora
    document.addEventListener('click', (e) => {
      if (!$popup.contains(e.target) && !e.target.classList.contains('word')) {
        closePopup();
      }
    });

    // Hotkeys: ESC fecha popup
    document.addEventListener('keydown', (e) => {
      if (e.key === 'Escape') closePopup();
    });
  </script>
</body>
</html>`;

// --- Rotas HTTP ---
app.get('/', (req, res) => {
  res.setHeader('Content-Type', 'text/html; charset=utf-8');
  res.send(page);
});

// Salvar/atualizar nota
app.post('/api/notes', (req, res) => {
  const { songId, index, note } = req.body || {};
  if (!songId || typeof index !== 'number') {
    return res.status(400).json({ error: 'songId e index são obrigatórios' });
  }
  if (!store[songId]) store[songId] = Object.create(null);
  if (typeof note === 'string' && note.trim() !== '') {
    store[songId][index] = note.trim();
  } else {
    delete store[songId][index];
  }
  return res.json({ ok: true });
});

// Consultar notas por songId
app.get('/api/notes', (req, res) => {
  const { songId } = req.query;
  if (!songId) return res.status(400).json({ error: 'songId obrigatório' });
  const notes = store[songId] || {};
  res.json({ notes });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`\n✔ Servidor rodando em http://localhost:${PORT}\n`);
});
