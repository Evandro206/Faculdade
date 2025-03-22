#include <stdio.h>
#include <stdbool.h>


void programa1(){ //função somar matrizes
     int tam = 3;
     int mtz1[tam][tam], mtz2[tam][tam], mtz3[tam][tam];

     printf("Digite os valores da matriz 1:\n"); //Receber matriz 1
     for(int i = 0; i < tam; i++){
         for(int j = 0; j < tam; j++){
             scanf("%d", &mtz1[i][j]);
         }
     }

     printf("Digite os valores da matriz 2:\n"); //Receber matriz 2
     for(int i = 0; i < tam; i++){
         for(int j = 0; j < tam; j++){
             scanf("%d", &mtz2[i][j]);
         }
     }

     for(int i = 0; i < tam; i++){ //Loop Para calcular matriz 3
         for(int j = 0; j < tam; j++){
             mtz3[i][j] = mtz1[i][j] + mtz2[i][j];
         }
     }

     printf("A soma das matrizes e:\n"); //Impressão matriz 3
     for(int i = 0; i < tam; i++){
         printf("%d | %d | %d \n", mtz3[i][0], mtz3[i][1], mtz3[i][2]);
     }
}

void programa2(){ //Função multiplicar matrizes
     int tam = 2;
     int mtz1[tam][tam], mtz2[tam][tam], mtz3[tam][tam];

     printf("Digite os valores da matriz 1:\n"); //Receber matriz 1
     for(int i = 0; i < tam; i++){
         for(int j = 0; j < tam; j++){
             scanf("%d", &mtz1[i][j]);
         }
     }

     printf("Digite os valores da matriz 2:\n"); //Receber matriz 2
     for(int i = 0; i < tam; i++){
         for(int j = 0; j < tam; j++){
             scanf("%d", &mtz2[i][j]);
         }
     }

     for(int i = 0; i < tam; i++){ //Loop Para calcular matriz 3
         for(int j = 0; j < tam; j++){
             mtz3[i][j] = mtz1[i][j] * mtz2[i][j];
         }
     }

     printf("A Multipicacao das matrizes e:\n"); //Impressão matriz 3
     for(int i = 0; i < tam; i++){
         printf("%d | %d \n", mtz3[i][0], mtz3[i][1]);
     }
}

void programa3(){ //Função transpor matrizes
     int tam = 3;
     int mtz1[tam][tam], mtz2[tam][tam];

     printf("Digite os valores da matriz:\n"); //Receber matriz 1
     for(int i = 0; i < tam; i++){
         for(int j = 0; j < tam; j++){
             scanf("%d", &mtz1[i][j]);
         }
     }

     for(int i = 0; i < tam; i++){ //Loop Para calcular matriz 3
         for(int j = 0; j < tam; j++){
             mtz2[j][i] = mtz1[i][j];
         }
     }

     printf("A transposta da matrizes e:\n"); //Impressão matriz 1
     for(int i = 0; i < tam; i++){
         printf("%d | %d | %d \n", mtz1[i][0], mtz1[i][1], mtz1[i][2]);
     }

     printf("A transposta da matrizes e:\n"); //Impressão matriz 2
     for(int i = 0; i < tam; i++){
         printf("%d | %d | %d \n", mtz2[i][0], mtz2[i][1], mtz2[i][2]);
     }
}

void selecaoprograma(){ //Função para escolha do programa
     int programa = 0;

     do{ //Loop caso resposta for invalida
         printf("Qual programa vc quer executar?\n");
         printf("1 - Soma matrizes 3 por 3\n");
         printf("2 - Multiplicacao matrizes 2 por 2\n");
         printf("3 - Transposta matrizes 3 por 3\n");
         scanf("%d", &programa);
     
         if(programa < 1 && programa > 3){ //Verificação resposta valida ou não
             printf("Resposta invalida!\n");
         }
     }while (programa < 1 && programa > 3);

     if(programa == 1){ //Verificação programa 1
         programa1();
         continuar(); //Executar função
     } else if(programa == 2){ //Verificação programa 2
         programa2();
         continuar(); //Executar função
     } else if(programa == 3){ //Verificação programa 3
         programa3();
         continuar(); //Executar função
     }
}

void continuar(){ //Função para ver se o usuario quer continuar
     bool Z; 
     int Y;

     printf("Voce deseja executar outro programa?\n");
     printf("1 - Sim\n");
     printf("0 - Nao\n");
     scanf("%d", &Y);

     Z = (Y != 0);
     
     if(Z){ //Verifcar se o programa continua
         selecaoprograma(); //Executar função
     } else {
         printf("Fim do programa!");
     }
}

int main(){
     selecaoprograma(); //Executar função
}