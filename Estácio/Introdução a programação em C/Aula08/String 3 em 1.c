#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>

#define tam 8 //Defini um tamanho fixo

void inverterstring(char str[tam]){ //Função responsável por inverter a String
      char a;
      int i = strlen(str) - 1; //Define i
      int j = 0; //Define j

      do{ //Loop para inverter toda a String
           a = str[j];
           str[j] = str[i];
           str[i] = a;
      j++;
      i--;
      }while(j < i);
}

void funcaovogais(char str[tam]){ //Função responsável por contar as vogais
      int A = 0; 
      int E = 0; 
      int I = 0; 
      int O = 0; 
      int U = 0; 
      int vogais = 0;
      int i = strlen(str) - 1; //Define i

      do{ //Loop para somar vogais
           char c = tolower(str[i]); // Converter para minúsculas para verificar todas as vogais

           if (c == 'a') { // Verifica se a letra é uma vogal
                A++;
                vogais++;
           } else if (c == 'e') {
                E++;
                vogais++;
           } else if (c == 'i') {
                I++;
                vogais++;
           } else if (c == 'o') {
                O++;
                vogais++;
           } else if (c == 'u') {
                U++;
                vogais++;
           }
      i--;
      }while(i >= 0);

      printf("O numero de vogais foi:\n"); //Impressão do resultado na tela
      printf("A = %d\n", A);
      printf("E = %d\n", E);
      printf("I = %d\n", I);
      printf("O = %d\n", O);
      printf("U = %d\n", U);
      printf("Total = %d\n", vogais);
}

bool funcaopalindromo(char str[tam]){ //Função para verificar se a palavra é palíndroma
      unsigned int cont;
      char str2[tam];

      int i = strlen(str) - 1; //Reseta i
      cont = 0; //Define cont

      strcpy(str2, str); //Copia a str para str2
      inverterstring(str); //Chamar a função

      do{ //Loop que verifica se as letras batem
           if(str[i] == str2[i]){
                cont++;
           } 
      i--;
      }while(i >= 0);

      if(cont == strlen(str)){ //Verifica se a função retorna verdadeiro ou falso
           return true;
      } else {
           return false;
      }
}

int main(){
      char str[tam];
 
      do{
      printf("Digite uma palavra de  ate %d letras:\n", tam - 1); //Solicitar a palavra a ser invertida
      fgets(str, tam, stdin);
      str[strcspn(str, "\n")] = '\0'; //Remover o caractere \n da String

      if(strlen(str) > (tam - 1)){ //Verificação se o numero de letras esta correto
           printf("A palavra deve ter no maximo %d letras!\n", tam - 1);
      }
      }while(strlen(str) > (tam - 1));
     
      printf("A palavra digitada foi: %s\n", str); //Imprimir a palavra inicial
      inverterstring(str); //Chamar a função
      printf("A palavra invertida  foi: %s\n", str); // Imprimir a palavra invertida

      if(funcaopalindromo(str) > 0){ //Chama função e exibe o resultado
           printf("A palavra e polindroma\n");
      }else{
           printf("A palavra nao e polindroma\n");
      }

      funcaovogais(str); // chama função 

    return 0;
}