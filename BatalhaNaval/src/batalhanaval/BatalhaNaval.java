package batalhanaval;

/**
 Regras
 * Os navios podem ser colocados horizontalmente ou verticalmente, mas não na diagonal.
    * Todo navio deve estar completamente na grade. Nenhum navio pode estar com alguma parte do lado de fora.
    * Os navios não podem ficar sobrepostos.
    * Para dar um tiro, escolha um quadrado sobre a grade, diga suas coordenadas de acordo com as linhas 
    * e as colunas na parte esquerda e superior da grade.
    * Por exemplo, o quadrado no canto superior esquerdo da grade é chamado de "1-1", uma vez que está localizado
    * na linha 2 e na coluna 2.
 * Se o primeiro jogador atingir um quadrado com um navio, o jogador 2 deve dizer "Fogo!" Simbolo 'x' onde foi atingido um barco
 * Se cada quadrado de um navio levar um tiro, o navio será afundado. O jogador deve então informar o seu adversário dizendo 
 * "Afundou meu ___," indicando qual tipo de navio foi afundado.
 * Tiros na água terão o simbolo 'a'
 * Continue atirando até que um jogador perca todos os seus navios. Os jogadores devem se alternar dando
 * um tiro de cada vez, independente de acertar ou não. Quem conseguir afundar todos os navios de seu oponente
 * primeiro, ganha o jogo.
 * 
 * Fonet: http://pt.wikihow.com/Jogar-Batalha-Naval
 */

import java.util.Scanner;

public class BatalhaNaval {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        int VS=0;
        int l,c;
        int vez=1;
        Jogador jogador1,jogador2;
        jogador1=new Jogador();
        System.out.println("Digite o seu nome: ");
        jogador1.nome=sc.nextLine();
        jogador1.idBarco();
        jogador1.MontarTabuleiro();
        
        jogador2=new Jogador();
        System.out.println("Digite o seu nome: ");
        jogador2.nome=sc.nextLine();
        jogador2.idBarco();
        jogador2.MontarTabuleiro();     
       
        
        while (VS==0){
            if (vez==1){
                System.out.println("Jogador 1 : "+ jogador1.nome);
                              
                jogador1.jogar(jogador2); 
                
                VS=jogador2.VerificarStatus(jogador2.cruzador.status, jogador2.destruidor.status, 
                                            jogador2.navioGuerra.status, jogador2.portaAvioes.status, 
                                            jogador2.submarino.status);
                if (VS==1){
                    System.out.println("Voce Ganhou o jogo!! ");
                    System.out.println("Ganhador" + jogador1.nome);
                    jogador1.imprimirTabuleiro();
                    System.out.println("");
                    System.out.println("Tabuleiro derrotado");
                    jogador2.imprimirTabuleiro();
                }
                vez=2;
                
            }
            
            else {
                System.out.println("Jogador 2 : "+ jogador2.nome);                 
                jogador2.jogar(jogador1); 
                
                VS=jogador1.VerificarStatus(jogador1.cruzador.status, jogador1.destruidor.status, 
                                            jogador1.navioGuerra.status, jogador1.portaAvioes.status, 
                                            jogador1.submarino.status);
                if (VS==1){
                    System.out.println("Voce Ganhou o jogo!! ");
                    System.out.println("Ganhador" + jogador2.nome);
                    jogador2.imprimirTabuleiro();
                    System.out.println("");
                    System.out.println("Tabuleiro derrotado");
                    jogador1.imprimirTabuleiro();
                }
                vez=1;
            }
        
        }
        
        
        
        
        
    }
}
    
    

