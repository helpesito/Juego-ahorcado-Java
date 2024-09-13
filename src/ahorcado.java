import java.util.Scanner;

public class ahorcado {
    public static void main(String[] args) throws Exception {

        //clase scanner que nos permite que el usuario escriba
        Scanner scanner = new Scanner(System.in);

        //declaraciones y asignaciones
        String palabraSecreta = "inteligencia";

        int intentosMaximos = 10;

        int intento = 0;

        boolean adivinada = false;

        //arreglos
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        //estructura de control: iterativa bucle*
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';

        }
        
        while(!adivinada && intento < intentosMaximos){
            System.out.println("palabra a adivinar " + String.valueOf(letrasAdivinadas) + " " + palabraSecreta.length() + " letras");

            System.out.println("quieres adivinar una letra o crees saber cual palabra es? (L/P)");
            //Usamos la clase scanner para pedir una letra charAt nos permite tomar la primera letra de lo que se escriba puesto que letra va a ser un string
            char opcion = Character.toLowerCase(scanner.next().charAt(0));
            

            if(opcion == 'p'){
                System.out.println("introduce la palabra completa: ");
                String palabra = scanner.next().toLowerCase();

                if(palabra.equals(palabraSecreta)){
                    adivinada = true;
                    System.out.println("¡felicidades! has adivinado la palabra secreta " + palabraSecreta);
                }else {
                    intento++;
                    System.out.println("¡incorrecto!, te quedan " + (intentosMaximos - intento) + " intentos");
                }

            }else if (opcion == 'l'){
                System.out.println("introduce la letra, por favor");
                char letra = Character.toLowerCase(scanner.next().charAt(0));
                boolean letraCorrecta = false;

                for (int i = 0; i < palabraSecreta.length(); i++) {
                    if (palabraSecreta.charAt(i) == letra){
                        letrasAdivinadas[i] = letra;
                        letraCorrecta = true;
                        
                    }
                }

                if (!letraCorrecta) {
                    intento++;
                    System.out.println("¡incorrecto! te quedan " + (intentosMaximos - intento) + " intentos");
                }
    
                if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                    adivinada = true;
                    System.out.println("¡felicidades! has adivinado la palabra secreta " + palabraSecreta);
                }
            }

        }

        if (!adivinada) {
            System.out.println("¡que pena! te has quedado sin intentos GAME OVER");
        }

        scanner.close();

    }
}
