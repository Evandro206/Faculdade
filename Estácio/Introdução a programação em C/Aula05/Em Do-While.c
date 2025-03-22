#include <stdio.h>
#include <stdbool.h>

int main(void) {
  float nota1, nota2, notamaxima, media, limite =0.75;
  int numerodefaltas, numerodeaulas, I, tentativas = 4;
  float frequencia, frequenciaminima;
  bool aprovado;
  I = 1;
  do{
    printf("Tentativa numero %d\n""=========================\n", I); 
    printf("Qual a nota maxima:\n");
     scanf("%f", &notamaxima);
    printf("Qual a primeira nota:\n");
      scanf("%f", &nota1);
    printf("Qual a segunda nota:\n");
      scanf("%f", &nota2);
        media = (nota1 + nota2) / 2;
  if (media < notamaxima * 0.6){
    aprovado = true;
  } else {
    aprovado = false;
  }
    printf("Qual o numero de aulas?\n");
       scanf("%d", &numerodeaulas);
    printf("Qual o numero de faltas?\n");
       scanf("%d", &numerodefaltas);
        frequencia = (float) numerodefaltas / numerodeaulas;
        frequenciaminima = numerodeaulas * limite;
  if (frequencia < frequenciaminima ){
    aprovado = true;
  } else {
    aprovado = false;
  }
  printf("Media: %.2f\n", media);
  printf("Frequencia: %.2f %%\n", (100 - (frequencia * 100)));
  if (aprovado == true){
    printf("Aprovado\n");
  } else {
    printf("Reprovado\n");
  }
    I = I + 1;
 } while (I <= tentativas);
  return 0;
}