#include <stdio.h>
#include <string.h>
#include <locale.h>
#include <ctype.h>
#include <stdbool.h>
#define Max_elements 1000

bool isFIM(char palavra[Max_elements]);
int tamanhoString(char palavra[]);

bool isPalin(char palavra[Max_elements], int i, int TAM)
{
  bool ispalin = true;
  if (i < TAM / 2)
  {
    if (palavra[i] == palavra[TAM - i - 1])
    {
    ispalin  = isPalin(palavra, i + 1, TAM);
    }
    else
    {
      ispalin = false;
    }
  }

  return ispalin;
}

int main()
{

  char palavra[Max_elements];
  int TAM;

  //ler entrada input
  fgets(palavra, Max_elements, stdin);
  while (!isFIM(palavra))
  {
    TAM = tamanhoString(palavra);
    if (isPalin(palavra, 0, TAM))
    {
      printf("SIM\n");
    }
    else
      printf("NAO\n");
    fgets(palavra, Max_elements, stdin);
  }
}

bool isFIM(char palavra[Max_elements])
{
  bool ehfim = false;

  if (strlen(palavra) > 3 && palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M')
  {
    ehfim = true;
  }

  return ehfim;
}

int tamanhoString(char palavra[Max_elements])
{
  int cont = 0;
  for (int i = 0; palavra[i] != '\n'; i++)
  {
    cont++;
  }
  return cont;
}

//fazer uma funçao para conferir se e palin
//fazer uma funçao para verificar flag == FIM
