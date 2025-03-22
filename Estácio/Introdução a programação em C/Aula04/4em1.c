#include <stdio.h>

int main(void) {

  int programa, multiplicador, multiplicado, resultado, numero_atual, numero_maior, numero_menor, soma, media, sim_nao;
  do {
    printf("Qual programa voce quer executar?\n");

    printf("1 - Tabuada do 5\n");
    printf("2 - Tabuada de Sua Escolha\n");
    printf("3 - Maior Numero Entre 20\n");
    printf("4 - Impares de 1 a 100\n");
    scanf("%d", &programa);

    if (programa >= 1 && programa <= 4) {
      if (programa == 1) {

        multiplicador = 0;

        do {
          resultado = 5 * multiplicador;
          printf("5 x %d = %d\n", multiplicador, resultado);
          multiplicador = multiplicador + 1;
        } while (multiplicador <= 10);
      } else if (programa == 2) {
        printf("Escolha um numero para a tabuada:\n");
        scanf("%d", &multiplicado);

        multiplicador = 0;

        do {
          resultado = multiplicado * multiplicador;
          printf("%d x %d = %d\n", multiplicado, multiplicador, resultado);
          multiplicador = multiplicador + 1;
        } while (multiplicador <= 10);
      } else if (programa == 3) {
        printf("Digite 20 numeros:\n");
        multiplicador = 0;
        numero_atual = 0;
        soma = 0;
        media = 0;
        do {
          scanf("%d", &numero_atual);
          soma = soma + numero_atual;
          if (numero_atual > numero_maior) {
            numero_maior = numero_atual;
          } else if (numero_atual < numero_menor) {
            numero_menor = numero_atual;
          } else {
          }
          if (multiplicador == 0){
            numero_menor = numero_atual;
            numero_maior = numero_atual;
          }
          multiplicador = multiplicador + 1;
        } while (multiplicador < 20);
        printf("O maior numero e: %d\n", numero_maior);
        printf("O menor numero e: %d\n", numero_menor);
        printf("A soma  e: %d\n", soma);
        media = soma / 20;
        printf("A media e: %d\n", media);
      } else if (programa == 4) {
        multiplicador = 0;
        printf("Os numeros impares de 1 a 100 sao:\n");
        numero_atual = 0;
        do {
          soma = numero_atual % 2;
          if (soma != 0) {
            printf("%d\n", numero_atual);
          } else {
          }
          numero_atual = numero_atual + 1;
          multiplicador = multiplicador + 1;
        } while (multiplicador < 100);
      } else {
      }
    } else {
      printf("Programa invalido\n");
    }
    do {
      printf("Quer executar outro programa?\n");
      printf("1 - Sim\n");
      printf("2 - Nao\n");
      scanf("%d", &sim_nao);
      if (sim_nao < 1 || sim_nao > 2) {
        printf("Opcao invalida\n");
      }
    } while (sim_nao < 1 || sim_nao > 2);
  } while (sim_nao == 1);
  printf("Programa encerrado");
  return 0;
}