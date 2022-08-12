import java.util.Scanner;
import java.util.Random;
import java.util.regex.*;

public class Ejercicios{
    static int op = 0; //variable que me ayuda a saber que opcion elige el usario
    static boolean tf = true; //mientras sea true la variable, se ejecutará el menú, hasta que el usuario le de a la opción 2 de un submenu
    public static void main(String[] args) throws Exception {

    while (tf){
        menu(); //menu principal
        switch (op){
            case 1:
            numenor(); //funciones de cada ejercicio
            ret(); //aca pregunto si quiere seguir ejecutando el programa o no
            break;

            case 2:
            numedio();
            ret();
            break;

            case 3:
            vocales();
            ret();
            break;

            case 4:
            password();
            ret();
            break;

            case 5:
            promedio();
            ret();
            break;

            case 6:
            maxmin();
            ret();
            break;

            case 7:
            tf = false;
            break;
        }
      
    }

    System.out.println("Gracias por utilizar mi programa :D.");
    }

    public static void menu(){ //le indico al usario las opciones que tiene para elegir
        Scanner reader = new Scanner(System.in);
        System.out.println("Bienvenido al menú principal \nPor favor, ingresa el número de la opción que deseas: ");
        System.out.println("1. Mostrar el número más pequeño de tres números. \n2. Determinar el caracter de en medio de un número o palabra. \n3. Contar las vocales de una palabra o frase. \n4. Verificar las cracteristicas de tu contraseña. \n5. Promedio de número aleatorios. \n6. Valor máximo y valor mínimo de un arreglo. \n7. Salir.");
        int num = reader.nextInt();
        op = num;
    }

    public static void numenor(){ //ejercicio 1
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Por favor, ingresar el primer valor: ");
        int num1 = reader.nextInt();
        System.out.println("Ingresa el segundo valor: ");
        int num2 = reader.nextInt();
        System.out.println("Ingresa el último valor: ");
        int num3 = reader.nextInt();
        numerom(num1, num2, num3); //le envio los numeros a una funcion que hace el ordenamiento de manera ascendente los 3 numeros y asi me muestra el menor
    }

    public static void numedio(){ //ejercicio 2
        Scanner reader = new Scanner(System.in);
        int tamaño = 0;

        System.out.println("Ingresa un dato a tu elección: ");
        String dato = reader.nextLine();
        String[] separar = dato.split("");
        for (int i = 0; i < separar.length; i++){
            tamaño = i;
        }
        tamaño = (tamaño + 1); //le sumamos 1 a la contadora porque un arreglo toma en cuenta el 0

        if (tamaño % 2 == 0){ //verificamos si la cantidad de espacios en el arreglo es par o impar
            System.out.println("La cantidad de caracteres es par.");
            System.out.println("Los datos centrales son: " + separar[(tamaño / 2) - 1] + " y " + separar[(tamaño /2)]);
        }else{
            System.out.println("La cantidad de caracteres es impar.");
            System.out.println("El dato central es: " + separar[tamaño / 2]);
        }
    }

    public static void vocales(){ //ejercicio 3
        Scanner reader = new Scanner(System.in);
        int contadora = 0;
        System.out.println("Ingresa la palabra o frase de la que quieras saber cuantas vocales tiene: ");
        String vocales = reader.nextLine();

        for (int v = 0; v < vocales.length(); v++){
            if((vocales.charAt(v) == 'a') || (vocales.charAt(v) == 'e') || (vocales.charAt(v) == 'i') || (vocales.charAt(v) == 'o') || (vocales.charAt(v) == 'u') || (vocales.charAt(v) == 'A') || (vocales.charAt(v) == 'E') || (vocales.charAt(v) == 'I') || (vocales.charAt(v) == 'O') || (vocales.charAt(v) == 'U')){
                contadora = (contadora + 1);
            }
        }
        System.out.println("La cantidad de vocales de " + "'" + vocales + "'" + " es de: " + contadora);
    }

    public static void password(){ //ejercicio 4
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingresa la contraseña a verificar: ");
        String password = reader.nextLine();
        char[] list = password.toCharArray();
        int numeros = 0;
        int letras = 0;
        int cont = 0;
        for (char c : list){ //comprobamos la cantidad de números que tiene la contraseña 
            if (Character.isDigit(c)){
                numeros = (numeros + 1);
            }else{
                letras = (letras + 1);
            }
        }
        int cant = 0;
        cant = (letras + numeros);

        if (cant >= 8){
            System.out.println("Tu contraseña cumple con los caracteres minimos. (8)");

            if (letras >= 2){
                cont = (cont + 1);
            }else{
                System.out.println("Agregale letras a tu contraseña.");
            }
            if (numeros >= 2){
                cont = (cont + 1);
            }else{
                System.out.println("Agregale numeros a tu contraseña.");
            }

            if (cont == 2){
                System.out.println("Felicidades, su contraseña posee las caracteristicas minimas.");
                System.out.println("La cantidad de letras es de " + letras);
                System.out.println("La cantidad de números es de: " + numeros);
            }else{
                System.out.println("Tu contraseña no posee los requerimientos necesarios :(.");
            }
        }else{
            System.out.println("Tu contraseña no cumple con los caracteres minimos.");
        }        
    }

    public static void promedio(){ //ejercicio 5
        int[] arr = new int [10];
        int suma = 0;
        int result = 0;
        int cont = 0;
        nrandom(arr); //le mandamos un arreglo a la funcion que se encarga de llenar este mismo arreglo de números aleatorios

        for (int m = 0; m < arr.length; m++){ 
            suma = (suma + arr[m]); //sumamos todos los números del arreglo
            cont = m; //la cantidad de números que hay en el arreglo
        }
        result = (suma / (cont + 1)); //calculamos el promedio
        System.out.println("El promedio es: " + result);
    }

    public static void maxmin(){ //ejercicio 6
        int[] arr = new int [10];
        int temp;
        nrandom(arr); //funcion que se encarga de llear el arreglo de numeros aleatorios
        for (int i = 0; i < arr.length; i++){  //ordenamos de manera descendente los números para saber en qué parte del arreglo esta el númeor mayor y el menor
            for(int n = 0; n < arr.length; n++){
                if (n < arr.length - 1){
                    if (arr[n] <= arr[n + 1]){
                        temp = arr[n];
                        arr[n] = arr[n +1];
                        arr[n + 1] = temp;
                        }
                    }
                }
            }
        System.out.println("El número más grande es: " + arr[0] + " y el más pequeño es: " + arr[9]);
    }

    public static void numerom(int num1, int num2, int num3){
        int[] array = new int[3];
        int temp = 0;
        array[0] = num1;
        array[1] = num2;
        array[2] = num3;
        for (int k = 0; k < array.length; k++){

            for(int e = 0; e < array.length; e++){

                if (e < array.length - 1){
                    if (array[e] >= array[e + 1]){
                        temp = array[e];
                        array[e] = array[e + 1];
                        array[e + 1] = temp;
                    }
                }
            }
        }

        System.out.println("El número menor de los tres es: " + array[0]);
    }

    public static void ret(){
        Scanner reader = new Scanner(System.in);
        System.out.println("¿Desea volver al menú principal? \n1. Continuar ejecutanto. \n2. Terminar el programa.");
        int des = reader.nextInt();

        if (des == 2){
            tf = false;
        }else{
            tf = true;
        }
        System.out.println("");
    }

    public static void nrandom(int[] arr){ 
        System.out.println("Números aleatorios: \n");
        for (int x = 0; x < 10;){
            Random r = new Random();
            int valor = r.nextInt(101);
            arr[x] = valor;
            System.out.print(arr[x] + ", ");
            x = (x + 1);
            }
        }
}