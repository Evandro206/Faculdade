#include <stdio.h>

int main(void) {
  int epaminondas, numeral, pares, impares, i = 0;
  printf("Quantos digitos tera seu numero?\n");
  scanf("%d", &epaminondas);
  char numero[epaminondas];
  printf("Digite o numero:\n");
  scanf(" %s", numero);
  do {
    if (numero[i] == '0') {
      numeral = 0;
    }
    if (numero[i] == '1') {
      numeral = 1;
    }
    if (numero[i] == '2') {
      numeral = 2;
    }
    if (numero[i] == '3') {
      numeral = 3;
    }
    if (numero[i] == '4') {
      numeral = 4;
    }
    if (numero[i] == '5') {
      numeral = 5;
    }
    if (numero[i] == '6') {
      numeral = 6;
    }
    if (numero[i] == '7') {
      numeral = 7;
    }
    if (numero[i] == '8') {
      numeral = 8;
    }
    if (numero[i] == '9') {
      numeral = 9;
    }
    if ((numeral % 2) == 0) {
      printf("O numero e par: %d\n", numeral);
      pares = pares + 1;
    } else {
      printf("O numero e impar: %d\n", numeral);
      impares = impares + 1;
    }
    printf("%d numeros são pares\n", pares);
    printf("%d numeros são impares\n", impares);
    i = i + 1;
  } while (i < epaminondas);
  return 0;
}