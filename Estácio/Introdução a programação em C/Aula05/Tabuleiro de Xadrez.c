#include <stdio.h>

int main(void) {
    for (int coluna = 1; coluna <= 8; coluna++) {
      for (int linha = 1; linha <= 8; linha++){
        if (coluna % 2 != 0) {
            if (linha % 2 == 0) {
                printf("#");
            } else {
                printf("@");
            }
        } else {
            if (linha % 2 != 0) {
                printf("#");
            } else {
                printf("@");
            }
        }
      }
      printf("\n");
    }
    return 0;
}