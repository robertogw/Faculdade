public class Lexema_semRep {
   static String [ ] tabelaSimbolos = new String [10];
   static int posicao = 1;     
   public static void main(String[] args) {
       Scanner leia = new Scanner (System.in);
       String fluxoCaracteres;
       char cAtual, cProximo;
       String lexema = "";
       String numero = "";
       String fluxoTokens = "";
       System.out.print("Digite uma expressao: ");
       fluxoCaracteres = leia.nextLine();
       int tamanhoFluxo = fluxoCaracteres.length();
       int posicaoRetorno;
       for (int i = 0; i < fluxoCaracteres.length(); i++) {
           cAtual = fluxoCaracteres.charAt(i);
           if ( i < tamanhoFluxo -  1 )
                   cProximo = fluxoCaracteres.charAt(i+1);                 
           else
                   cProximo = ' ';                 
           if (Character.isLetter (cAtual) || (Character.isDigit (cAtual) && lexema.length() > 0)) { 
               lexema += cAtual;
               if (!Character.isLetter(cProximo) && !Character.isDigit(cProximo)) {
                   posicaoRetorno = pesquisaTabelaSimbolos (lexema);
                   if (posicaoRetorno == 0) {
                       tabelaSimbolos [posicao] = lexema;                                           
                       fluxoTokens += "<id,"+posicao+">";             
                       posicao ++;
                   } else {
                       fluxoTokens += "<id,"+posicaoRetorno+">";                       
                   }                     
                   lexema = "";
               }
           }                         
           else if ( Character.isDigit(cAtual)) {
               numero += cAtual;
               if ( ! Character.isDigit(cProximo)) {
                   fluxoTokens += "<"+numero+">";                   
                   numero = "";
               }
           }                           
           else if (cAtual == '/' && cProximo == '/') {
               break;
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
       System.out.println("Tabela de símbolos:");       
       for (int i = 1; i < posicao; i ++) {
           System.out.println(tabelaSimbolos[i]);
       }       
   }
   public static int pesquisaTabelaSimbolos (String s) {
       for (int i = 1; i < posicao; i ++) {
           if ( s . equals (tabelaSimbolos [i] ) ) {
               return i;
           }
       }                         
       return 0;                                     
   }
}
