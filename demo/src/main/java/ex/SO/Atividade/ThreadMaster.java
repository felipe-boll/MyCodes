package ex.SO.Atividade;

public class ThreadMaster {
    public void letsDoSomeCalc(){
        double[] vet = new double[10];
        int cpu_threads = 3;
        
        Thread[] vet_threads = new Thread[cpu_threads];

        for(int i = 0; i < cpu_threads; i++) {
            vet_threads[i] = new Thread(new ThreadCalc(i, vet, cpu_threads));
            vet_threads[i].start();
        }
    }
}
