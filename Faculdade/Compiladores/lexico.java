import java.util.Scanner;
public class lexico {
    public static void main(String[] args) {
        Scanner leia = new Scanner (System.in);
        String fluxoCaracteres;
        String [ ] tabelaSimbolos = new String [10];
        char cAtual;
		char cProximo;
        String lexema = "";
        String numero = "";
        String fluxoTokens = "";
        System.out.print("Digite uma expressao: ");
        fluxoCaracteres = leia.nextLine();
        int tamanhoFluxo = fluxoCaracteres.length();
        int posicao = 1;         
        for (int i = 0; i < fluxoCaracteres.length(); i ++) {
            cAtual = fluxoCaracteres.charAt(i);
            
            
            if (Character.isLetter(cAtual)) {            
                lexema += cAtual;
                if(i+1 < fluxoCaracteres.length()){
                	cProximo = fluxoCaracteres.charAt(i + 1);                	
                } else {
                	cProximo = ' ';
                }                              
                if ( ! Character.isLetter(cProximo)) {
                    fluxoTokens += "<id,"+posicao+">";
                    tabelaSimbolos [posicao] = lexema;
                    posicao ++;
                    lexema = "";                    
                }
            }
            else if (Character.isDigit(cAtual)) {
                numero += cAtual;
                if(i+1 < fluxoCaracteres.length()){
                	cProximo = fluxoCaracteres.charAt(i + 1);                	
                } else {
                	cProximo = ' ';
                }                              
                if ( ! Character.isDigit(cProximo)) {
                    fluxoTokens += "<"+numero+">";
                    lexema = "";                    
                }
            }
            else if (cAtual == '+' || cAtual == '*' || cAtual == '=')
                fluxoTokens += "<"+cAtual+">";                
            else if (Character.isWhitespace(cAtual))
                ;            
            else
                fluxoTokens += "<Erro>";       
        }
        System.out.println("Fluxo de tokens:");
        System.out.println(fluxoTokens);
        System.out.println("Tabela de s�mbolos:");        
        for (int i = 1; i < posicao; i ++) {
            System.out.println(tabelaSimbolos[i]);
        }        
    }
}
