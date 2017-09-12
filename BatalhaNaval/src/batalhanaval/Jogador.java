package batalhanaval;


import java.util.Scanner;

public class Jogador {

    Scanner sc = new Scanner(System.in);

    public String nome;
    public int tabuleiro[][] = new int[11][11];
    public Barco portaAvioes;
    public Barco navioGuerra;
    public Barco submarino;
    public Barco cruzador;
    public Barco destruidor;

    //Função cria e da valor aos barcos do jogador
    public void idBarco() {
        portaAvioes = new Barco();
        portaAvioes.tamanho = 5;
        portaAvioes.nome = "Porta Aviões";
        portaAvioes.status = true;
        portaAvioes.contador = 0;

        navioGuerra = new Barco();
        navioGuerra.tamanho = 4;
        navioGuerra.nome = "Navio de Guerra";
        navioGuerra.status = true;
        navioGuerra.contador = 0;

        cruzador = new Barco();
        cruzador.tamanho = 3;
        cruzador.nome = "Cruzador";
        cruzador.status = true;
        cruzador.contador = 0;

        submarino = new Barco();
        submarino.tamanho = 3;
        submarino.nome = "Submarino";
        submarino.status = true;
        submarino.contador = 0;

        destruidor = new Barco();
        destruidor.tamanho = 2;
        destruidor.nome = "Destruidor";
        destruidor.status = true;
        destruidor.contador = 0;
    }

    //monta o tabuleiro e chama a função para posicionar os barcos
    void MontarTabuleiro() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0) {
                    tabuleiro[i][j] = j;
                }
                if (j == 0) {
                    tabuleiro[i][j] = i;
                }
            }
        }
        imprimirTabuleiro();

        PosicionarBarcos(portaAvioes);
        imprimirTabuleiro();
        PosicionarBarcos(navioGuerra);
        imprimirTabuleiro();
        PosicionarBarcos(cruzador);
        imprimirTabuleiro();
        PosicionarBarcos(submarino);
        imprimirTabuleiro();
        PosicionarBarcos(destruidor);
        imprimirTabuleiro();
    }
    
     void MontarTabuleiroMaquina() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0) {
                    tabuleiro[i][j] = j;
                }
                if (j == 0) {
                    tabuleiro[i][j] = i;
                }
            }
        }
        PosicionarBarcosMaquina(portaAvioes);
        PosicionarBarcosMaquina(navioGuerra);
        PosicionarBarcosMaquina(cruzador);
        PosicionarBarcosMaquina(submarino);
        PosicionarBarcosMaquina(destruidor);
        //teste 
        //imprimirTabuleiro();
    }

    // posiciona os barcos no tabuleiro 
    void PosicionarBarcos(Barco barco) {
        int l, c;
        String orient;
        boolean check = true;
        int checkTab = 0;
        int x;

        do {
            if (check == false) {
                check = true;
            }
            do {
                System.out.println("Digite a linha para colocar o " + barco.nome
                        + " O tamanho dele é: " + barco.tamanho);
                l = Integer.parseInt(sc.nextLine());
            } while ((l < 1) || (l > 10));

            do {
                System.out.println("Digite a coluna para colocar o " + barco.nome
                        + " O tamanho dele é: " + barco.tamanho);
                c = Integer.parseInt(sc.nextLine());
            } while ((c < 1) || (c > 10));

            do {
                System.out.println("Digite 'V' para colocar na vertical ou 'H' para colocar na horizontal");
                orient = sc.nextLine();
            } while ((orient.equals("h")) && (orient.equals("H")) && (orient.equals("v")) && (orient.equals("V")));

            if ((orient.equals("H")) || (orient.equals("h"))) {
                x = (c-1) + barco.tamanho;
                if (x > 10) {
                    check = false;
                } else {
                    for (int i = l; i <= l; i++) {
                        for (int j = c; j < x; j++) {
                            if (tabuleiro[i][j] != 0) {
                                checkTab += 1;
                            }
                        }
                    }

                    if (checkTab != 0) {
                        check = false;
                        checkTab = 0;
                    }
                }
            } else {
                x = (l-1) + barco.tamanho;
                if (x > 10) {
                    check = false;
                } else {

                    for (int i = l; i <= x; i++) {
                        for (int j = c; j <= c; j++) {
                            if (tabuleiro[i][j] != 0) {
                                checkTab += 1;
                            }
                        }
                    }

                    if (checkTab != 0) {
                        check = false;
                        checkTab = 0;
                    }

                }
            }
            if (check == false) {
                System.out.println("Não é possivel posicionar o barco nessa posição");
                System.out.println("Escolha quadrados livres e o tamanho do barco deve caber no tabuleiro");
                x = 0;
            }
        } while (check == false);

        if ((orient.equals("H")) || (orient.equals("h"))) {
            for (int i = l; i <= l; i++) {
                for (int j = c; j <= x; j++) {
                    if (barco.tamanho != 3) {
                        tabuleiro[i][j] = barco.tamanho;
                    } else {
                        if (barco.nome.equals("Submarino")) {
                            tabuleiro[i][j] = 32;
                        } else {
                            tabuleiro[i][j] = 31;
                        }
                    }
                }
            }

        } else {
            for (int i = l; i <= x; i++) {
                for (int j = c; j <= c; j++) {
                    if (barco.tamanho != 3) {
                        tabuleiro[i][j] = barco.tamanho;
                    } else {
                        if (barco.nome.equals("Submarino")) {
                            tabuleiro[i][j] = 32;
                        } else {
                            tabuleiro[i][j] = 31;
                        }
                    }
                }
            }
        }
    }
    
    //posiciona os barcos de forma aleatória pro jogador máquina
     void PosicionarBarcosMaquina(Barco barco) {
        //Random l=new Random();
        //Random c=new Random();
       // Random orientacao=new Random();
        boolean check = true;
        int checkTab = 0;
        int x;
        int l, c, orientacao ;

        do {
            if (check == false) {
                check = true;
            }
             l = (int) (1+ (Math.random()*10));
             c = (int) (1+ (Math.random()*10));
             orientacao = (int) (1+ (Math.random()*2));
           
         

            if (orientacao==1) {
                x = (c-1) + barco.tamanho;
                if (x > 10) {
                    check = false;
                } else {
                    for (int i = l; i <= l; i++) {
                        for (int j = c; j < x; j++) {
                            if (tabuleiro[i][j] != 0) {
                                checkTab += 1;
                            }
                        }
                    }

                    if (checkTab != 0) {
                        check = false;
                        checkTab = 0;
                    }
                }
            } else {
                x = (l-1) + barco.tamanho;
                if (x > 10) {
                    check = false;
                } else {

                    for (int i = l; i <= x; i++) {
                        for (int j = c; j <= c; j++) {
                            if (tabuleiro[i][j] != 0) {
                                checkTab += 1;
                            }
                        }
                    }

                    if (checkTab != 0) {
                        check = false;
                        checkTab = 0;
                    }

                }
            }
            if (check == false) {
                x = 0;
            }
        } while (check == false);

         if (orientacao==1) {
            for (int i = l; i <= l; i++) {
                for (int j = c; j <= x; j++) {
                    if (barco.tamanho != 3) {
                        tabuleiro[i][j] = barco.tamanho;
                    } else {
                        if (barco.nome.equals("Submarino")) {
                            tabuleiro[i][j] = 32;
                        } else {
                            tabuleiro[i][j] = 31;
                        }
                    }
                }
            }

        } else {
            for (int i = l; i <= x; i++) {
                for (int j = c; j <= c; j++) {
                    if (barco.tamanho != 3) {
                        tabuleiro[i][j] = barco.tamanho;
                    } else {
                        if (barco.nome.equals("Submarino")) {
                            tabuleiro[i][j] = 32;
                        } else {
                            tabuleiro[i][j] = 31;
                        }
                    }
                }
            }
        }
    }
    

    // grava a jogada no tabuleiro
    void jogar( Jogador jogador) {
        System.out.println("Meu tabuleiro");
        this.imprimirTabuleiro();
        System.out.println("Tabuleiro Adversário");
        jogador.imprimirTabuleiroAdv();
        int l, c;

        do {
            do {
                System.out.println("Digite a linha[1-10]");
                l = Integer.parseInt(sc.nextLine());
            } while ((l < 1) || (l > 10));

            do {
                System.out.println("Digite a coluna[1-10]");
                c = Integer.parseInt(sc.nextLine());
            } while ((c < 1) || (c > 10));
            
             if ( (jogador.tabuleiro[l][c]==1) || (jogador.tabuleiro[l][c]==6) ){
                 System.out.println("Este movimento já foi feito");
             }
            
        } while( (jogador.tabuleiro[l][c]==1) || (jogador.tabuleiro[l][c]==6) );
        
        if (jogador.tabuleiro[l][c] == 0) {
                jogador.tabuleiro[l][c] = 1;
                System.out.println("Tiro na água");
                System.out.println("");
            }
        else if (jogador.tabuleiro[l][c] == 2){
            jogador.tabuleiro[l][c] = 6;
            jogador.destruidor.contador+=1;
            jogador.destruidor.alterarStatus();
            System.out.println("Fogo!");
            if (jogador.destruidor.status==false){
                System.out.println("Voce afundou o Destruidor");
            }
            System.out.println("");
        }
        else if (jogador.tabuleiro[l][c] ==31){
            jogador.tabuleiro[l][c] = 6;
            jogador.cruzador.contador+=1;
            jogador.cruzador.alterarStatus();
            System.out.println("Fogo!");
            if (jogador.cruzador.status==false){
                System.out.println("Voce afundou o Cruzador");
            }
            System.out.println("");
        }
        else if (jogador.tabuleiro[l][c] == 32){
            jogador.tabuleiro[l][c] = 6;
            jogador.submarino.contador+=1;
            jogador.submarino.alterarStatus();
            System.out.println("Fogo!");
            if (jogador.submarino.status==false){
                System.out.println("Voce afundou o Submarino");
            }
            System.out.println("");
        }
        
        else if (jogador.tabuleiro[l][c] == 4){
            jogador.tabuleiro[l][c] = 6;
            jogador.navioGuerra.contador+=1;
            jogador.navioGuerra.alterarStatus();
            System.out.println("Fogo!");
            if (jogador.navioGuerra.status==false){
            System.out.println("Voce afundou o Navio de Guerra");
            }
            System.out.println("");
        }
        else{
            jogador.tabuleiro[l][c] = 6;
            jogador.portaAvioes.contador+=1;
            jogador.portaAvioes.alterarStatus();
            System.out.println("Fogo!");
            if (jogador.portaAvioes.status==false){
            System.out.println("Voce afundou o Porta Aviões");
            }
            System.out.println("");
            
        }

    }

    
    // grava a jogada no tabuleiro
    void jogarMaquina( Jogador jogador) {
        int l, c;

        do {
             l = (int) (1+ (Math.random()*10));
             c = (int) (1+ (Math.random()*10));
                        
             if ( (jogador.tabuleiro[l][c]==1) || (jogador.tabuleiro[l][c]==6) ){
                 //System.out.println("Este movimento já foi feito");
             }
            
        } while( (jogador.tabuleiro[l][c]==1) || (jogador.tabuleiro[l][c]==6) );
        
        if (jogador.tabuleiro[l][c] == 0) {
                jogador.tabuleiro[l][c] = 1;
                System.out.println("Tiro na água");
                System.out.println("");
            }
        else if (jogador.tabuleiro[l][c] == 2){
            jogador.tabuleiro[l][c] = 6;
            jogador.destruidor.contador+=1;
            jogador.destruidor.alterarStatus();
            System.out.println("Fogo!");
            if (jogador.destruidor.status==false){
                System.out.println("Voce afundou o Destruidor");
            }
            System.out.println("");
        }
        else if (jogador.tabuleiro[l][c] ==31){
            jogador.tabuleiro[l][c] = 6;
            jogador.cruzador.contador+=1;
            jogador.cruzador.alterarStatus();
            System.out.println("Fogo!");
            if (jogador.cruzador.status==false){
                System.out.println("Voce afundou o Cruzador");
            }
            System.out.println("");
        }
        else if (jogador.tabuleiro[l][c] == 32){
            jogador.tabuleiro[l][c] = 6;
            jogador.submarino.contador+=1;
            jogador.submarino.alterarStatus();
            System.out.println("Fogo!");
            if (jogador.submarino.status==false){
                System.out.println("Voce afundou o Submarino");
            }
            System.out.println("");
        }
        
        else if (jogador.tabuleiro[l][c] == 4){
            jogador.tabuleiro[l][c] = 6;
            jogador.navioGuerra.contador+=1;
            jogador.navioGuerra.alterarStatus();
            System.out.println("Fogo!");
            if (jogador.navioGuerra.status==false){
            System.out.println("Voce afundou o Navio de Guerra");
            }
            System.out.println("");
        }
        else{
            jogador.tabuleiro[l][c] = 6;
            jogador.portaAvioes.contador+=1;
            jogador.portaAvioes.alterarStatus();
            System.out.println("Fogo!");
            if (jogador.portaAvioes.status==false){
            System.out.println("Voce afundou o Porta Aviões");
            }
            System.out.println("");
            
        }

    }
    
    void imprimirTabuleiro() {
        /**
         * 0= quadrado não jogado - imprimir " " 1= agua - imprimir a 2= barco
         * destridor 31= barco cruzador 32 = barco submario 4= navio de guerra
         * 5= porta avioes barcos escondido imprimir " " 6 = barcos descobertos
         * - imprimir x
         *
         *
         */
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if ((i == 0) || (j == 0)) {
                    System.out.printf("| %2d ", tabuleiro[i][j]);

                } else {
                    if (tabuleiro[i][j] == 1) {
                        System.out.printf("| a  ");
                    } else if (tabuleiro[i][j] == 6) {
                        System.out.printf("| x  ");
                    } else if (tabuleiro[i][j] == 0) {
                        System.out.printf("|    ");
                    } else if (tabuleiro[i][j] == 2) {
                        System.out.printf("| D  ");
                    } else if (tabuleiro[i][j] == 31) {
                        System.out.printf("| C  ");
                    } else if (tabuleiro[i][j] == 32) {
                        System.out.printf("| S  ");
                    } else if (tabuleiro[i][j] == 4) {
                        System.out.printf("| NG ");
                    }else{
                        System.out.printf("| PA ");
                    }
                }

                if (j == 10) {
                    System.out.printf("|");
                    System.out.printf("\n");
                }
            }
        }
        System.out.println("");

    }

    void imprimirTabuleiroAdv() {
        /**
         * 0= quadrado não jogado - imprimir " " 1= agua - imprimir a 2= barco
         * destridor 31= barco cruzador 32 = barco submario 4= navio de guerra
         * 5= porta avioes barcos escondido imprimir " " 6 = barcos descobertos
         * - imprimir x
         *
         *
         */
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if ((i == 0) || (j == 0)) {
                    System.out.printf("| %2d ", tabuleiro[i][j]);
                } else {

                    if (tabuleiro[i][j] == 1) {
                        System.out.printf("| a  ");
                    } else if (tabuleiro[i][j] == 6) {
                        System.out.printf("| x  ");
                    } else {
                        System.out.printf("|    ");
                    }
                }

                if (j == 10) {
                    System.out.printf("|");
                    System.out.printf("\n");
                }
            }
            System.out.println("");
        }

    }
    
   

    public int VerificarStatus(boolean status1, boolean status2, boolean status3,
            boolean status4, boolean status5) {
        boolean check[] = {status1, status2, status3, status4, status5};
        int cont = 0;
        for (int i = 0; i < 5; i++) {
            if (check[i] == false) {
                cont += 1;
            }
        }

        if (cont == 5) {
            return 1;
        } else {
            return 0;
        }
    }

}
