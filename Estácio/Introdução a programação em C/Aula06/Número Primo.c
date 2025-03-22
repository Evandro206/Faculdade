#include <stdio.h>

int main(void) {
  int h, i, j, k, l=0;
  printf("Digite dois numeros com um espaço entre eles:\n ");
  scanf("%d", &i);
  scanf("%d", &j);
  for (h = i; h <= j; h++) {
    for (k = 1; k <= h; k++) {
      if (h % k == 0) {
        l++;
      }
    }
    if (l == 2) {
      printf("O numero %d é primo\n", h);
    }
    l = 0;
  }
  return 0;
}