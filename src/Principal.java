import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class Principal {

    public static void main(String[] args){
        Filme meuFilme = new Filme();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);
        meuFilme.setDuracaoEmMinutos(180);

        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());


        meuFilme.exibiFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("Total de avaliações " + meuFilme.getTotalDeAvaliacoes());

        System.out.println(meuFilme.pegaMedia());

        Serie serie = new Serie();

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.exibiFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração do filme: " + lost.getDuracaoEmMinutos());

        Filme favorito = new Filme();
        favorito.setNome("The Matrix");
        favorito.setAnoDeLancamento(1999);
        favorito.setDuracaoEmMinutos(135);
        favorito.setIncluidoNoPlano(true);

        Filme outro = new Filme();
        outro.setNome("John Wick");
        outro.setAnoDeLancamento(2014);
        outro.setDuracaoEmMinutos(101);
        outro.setIncluidoNoPlano(true);

        Serie series = new Serie();
        series.setNome("La Casa de Papel");
        series.setAnoDeLancamento(2017);
        series.setIncluidoNoPlano(true);
        series.setAtiva(true);
        series.setTemporadas(5);
        series.setEpisodiosPorTemporada(10);
        series.setMinutosPorEpisodio(45);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(favorito);
        calculadora.inclui(outro);
        calculadora.inclui(serie);

        System.out.println("Tempo total: " +calculadora.getTempoTotal());




    }
}
