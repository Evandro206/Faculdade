#include <stdio.h>
#include <time.h>

int main(void) {
  // Definição das variaveis
  int semanas, semana, mes, ano, dia, anoinicial, i = 0;
  struct tm *data_hora_atual;
  time_t segundos;

  // Variaveis de tempo real
  printf("Quantas semanas voce deseja para o quadro de horarios de aulas?\n");
  scanf("%d", &semanas);
  time(&segundos);
  data_hora_atual = localtime(&segundos);
  dia = data_hora_atual->tm_mday;
  mes = data_hora_atual->tm_mon + 1;
  semana = (data_hora_atual->tm_yday + data_hora_atual->tm_wday) / 7;
  ano = data_hora_atual->tm_year + 1900;
  anoinicial = 2020;

  // Do-while responsavel por printar o quadro
  do {
    printf("-------------------------------------------------------\n");
    printf("----------| Semana: %d | Mes: %d | Ano: %d |----------\n", semana,
           mes, ano);
    printf("| Dia | Seg |   Ter   |   Qua   |   Qui   | Sex | Sab |\n");
    printf("| %d  | --- |  18:55  |  18:55  |  18:55  | --- | --- |\n", dia);
    printf("-------------------------------------------------------\n");

    // Do-while responsavel por fazer a soma e verifição das datas
    do {
      // Faz a verificação se o ano é bissexto
      if (((ano - anoinicial) % 4) != 0) {
        // Faz a verificação se o mes tem 31 dias
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 ||
            mes == 10 || mes == 12) {
          if (dia >= 31) {
            mes = mes + 1;
            dia = 1;
          }
        } // Faz a verificação se o mes tem 30 dias
        else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
          if (dia >= 30) {
            mes = mes + 1;
            dia = 1;
          }
        } // Faz a verificação se o mes é Fevereiro
        else if (mes == 2) {
          if (dia >= 28) {
            mes = mes + 1;
            dia = 1;
          }
        } // Faz a verificação se o ano é bissexto
      } else if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
        // Faz a verificação se o mes tem 31 dias
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 ||
            mes == 10 || mes == 12) {
          if (dia >= 31) {
            mes = mes + 1;
            dia = 1;
          }
        } // Faz a verificação se o mes tem 30 dias
        else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
          if (dia >= 30) {
            mes = mes + 1;
            dia = 1;
          }
        } // Faz a verificação se o mes é Fevereiro
        else if (mes == 2) {
          if (dia >= 29) {
            mes = mes + 1;
            dia = 1;
          }
        }
      } // Soma dos dias
      dia = dia + 7;
      // Faz a verificação se completou um ano
      if (mes > 12) {
        mes = 1;
        ano = ano + 1;
      } // Verificação se o codigo ainda deve ser executado pelo numero de semanas
      semana = semana + 1;
    } while (semana <= semanas);
    // Verificação se o codigo ainda deve ser executado pelo i
    i = i + 1;
  } while (i <= semanas);
  return 0;
}