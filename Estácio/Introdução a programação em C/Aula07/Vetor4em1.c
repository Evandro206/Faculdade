#include <stdio.h>

int main(void) {
  int i, h, soma = 0, menor, maior, tamanho_vetor, progama,
            sim_nao;
  int vetor_um[10];
  int vetor_dois[8];
  h = 1;
  
  do {
    printf("Qual programa voce quer executar:\n 1 - Soma\n 2 - Maior e Menor\n "
           "3 - Inverter\n 4 - Valor dentre 20\n");
    scanf("%d", &progama);

    if (progama >= 1 && progama <= 4) {
      if (progama == 1) {
        tamanho_vetor = 10;
        for (i = 0; i < tamanho_vetor; i++) {
          printf("Digite o valor do vetor %d: ", (i + 1));
          scanf("%d", &vetor_um[i]);
          soma = soma + vetor_um[i];
        }
        printf("A soma dos valores do vetor e: %d\n", soma);
      } else if (progama == 2) {
        tamanho_vetor = 15;
        for (i = 0; i < tamanho_vetor; i++) {
          printf("Digite o valor do vetor %d: ", (i + 1));
          scanf("%d", &vetor_um[i]);
          if (i == 0) {
            menor = vetor_um[i];
            maior = vetor_um[i];
          }
          if (vetor_um[i] < menor) {
            menor = vetor_um[i];
          } else if (vetor_um[i] > maior) {
            maior = vetor_um[i];
          }
        }
        printf("O menor valor do vetor e: %d\n", menor);
        printf("O maior valor do vetor e: %d\n", maior);
      } else if (progama == 3) {
        tamanho_vetor = 8;
        for (i = 0; i < tamanho_vetor; i++) {
          printf("Digite o valor do vetor %d: ", (i + 1));
          scanf("%d", &vetor_um[i]);
        }
        h = 0;
        for (i = tamanho_vetor - 1; i >= 0; i--) {
          vetor_dois[h] = vetor_um[i];
          h++;
        }
        printf("Vetor invertido:\n");
        for (i = 0; i < tamanho_vetor; i++) {
          printf("%d ", vetor_dois[i]);
        }
        printf("\n");
      } else if (progama == 4) {
        soma = 0;
        tamanho_vetor = 20;
        printf("Digite um numero que voce quer encontrar:\n");
        scanf("%d", &maior);
        for (i = 0; i < tamanho_vetor; i++) {
          printf("Digite o valor do vetor %d: ", (i + 1));
          scanf("%d", &vetor_um[i]);
          if (vetor_um[i] == maior) {
            soma++;
          }
        }
        printf("O numero %d aparece %d vezes no vetor.\n", maior, soma);
      }
    } else {
      printf("Programa invalido\n");
    }
    do {
      printf("Quer executar outro programa?\n 1 - sim\n 2 - nao:\n ");
      scanf("%d", &sim_nao);
      if (sim_nao < 1 || sim_nao > 2) {
        printf("Opcao invalida\n");
      }
    } while (sim_nao < 1 || sim_nao > 2);
  } while (sim_nao == 1);
  printf("Programa encerrado\n");
  return 0;
}
