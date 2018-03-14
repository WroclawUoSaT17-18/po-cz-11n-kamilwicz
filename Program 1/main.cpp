#include <iostream>
#include <windows.h>
#include <cstdlib>
#include <stdio.h>


using namespace std;

class  Bryla
{

  public:
    double wysokoscS;
    double wysokoscP;
    double promien;
    double bokA;
    double bokB;
    int nr;
    double dlugoscL;
/*
    void wybierz_figure();
    void dodaj_liczby_stozek();
    double obliczanie_objetosci_stozek(double a, double b);
    double obliczanie_pola_stozek(double a, double b, double c);

    void dodaj_liczby_prostopadloscian();
    double obliczanie_objetosci_prostopadloscian(double a, double b, double c);
    double obliczanie_pola_prostopadloscian(double a, double b, double c);
*/



void wybierz_figure()
{
    int nr;
        cout << "WYBIERZ FIGURE" << endl;
        cout << "1.stozek " << endl;
        cout << "2.prostopadloscian " << endl;
        cout << "Podaj nr: ";
        cin >> nr;

        if(nr==1)
            {
                dodaj_liczby_stozek();
                cout << "Objetosc to: " << obliczanie_objetosci_stozek(promien,wysokoscS)<<endl;
                cout << "Pole powierzchni calkowitej to: " << obliczanie_pola_stozek(promien,wysokoscS,dlugoscL)<<endl<<endl;
                getchar();getchar();
                system("cls");
            }
        else if(nr==2)
            {
                dodaj_liczby_prostopadloscian();
                cout << "Objetosc to: " << obliczanie_objetosci_prostopadloscian(wysokoscP,bokA,bokB)<<endl;
                cout << "Pole powierzchni calkowitej to: " << obliczanie_pola_prostopadloscian(bokA,bokB,wysokoscP)<<endl<<endl;
                getchar();getchar();
                system("cls");
            }
        else
        {
            cout << "Niepoprawny wybor! Sprobuj jeszcze raz.";
            getchar();getchar();
            system("cls");
        }
}


void dodaj_liczby_stozek()
    {
		cout<<endl<<"DODAWANIE WARTOSCI DO BAZY"<<endl;
        cout<<"Podaj promien r: ";
        cin>>promien;
        cout<<"Podaj wysokosc h: ";
        cin>>wysokoscS;
        cout<<"Podaj dlugosc l: ";
        cin>>dlugoscL;
	}

double obliczanie_objetosci_stozek(double a, double b)
    {
        double objetosc=0;
        objetosc=((3.14*(a*a)*b)/3);
        return objetosc;
    }

double obliczanie_pola_stozek(double a, double b, double c)
    {
        double pole=0;
        pole=((3.14*a)*(a+c));
        return pole;
    }

void dodaj_liczby_prostopadloscian()
    {
		cout<<endl<<"DODAWANIE WARTOSCI DO BAZY"<<endl;
        cout<<"Podaj wysokosc h: ";
        cin>>wysokoscP;
        cout<<"Podaj dlugosc boku podstawy a: ";
        cin>>bokA;
        cout<<"Podaj dlugosc boku podstawy b: ";
        cin>>bokB;
	}

double obliczanie_objetosci_prostopadloscian(double a, double b, double c)
    {
        double objetosc=0;
        objetosc=a*b*c;
        return objetosc;
    }

double obliczanie_pola_prostopadloscian(double a, double b, double c)
    {
        double pole=0;
        pole=(2*((a*b)+(a*c)+(b*c)));
        return pole;

    }
};

    int main()
        {
            while(1)
            {
                Bryla b1;
                b1.wybierz_figure();
                Bryla b2;
                b2.wybierz_figure();

            }
            return 0;
        }






