Trebuie sa schimbam calea din ConexiuneProlog.java

Portul din ExempluInterfataProlog



Atentie! cerinte valabile pentru toti:

(1.0)Sistemele expert trebuie sa contina aproximativ 70-100 de reguli.
 In aceasta categorie se va puncta si corectitudinea lor

(0.5)Sa existe minim un caz de raspus al sistemului care sa aiba in istoric 
minim 3 reguli (exemplu: regula r1 care calculeaza valoarea atributului scop 
sa aiba printre premise un atribut a1 calculat cu ajutorul regulii r2 care sa 
aiba de asemenea printre premise un atribut calculat cu ajutorul unei reguli r3).

(0.5)Trebuie sa aveti si intrebari cu raspuns boolean (da/nu) si intrebari cu raspuns multiplu.

(0.5)De asemenea sa existe un caz in care sistemul expert nu da solutii.

(0.5)Daca sistemul nu da solutii, atunci se va afisa pe ecran un mesaj in care 
se indica faptul ca nu exista solutii.

(0.5)Sa existe macar o secventa de raspunsuri la intrebari, prin care se obtin
 mai multe solutii posibile.

(0.5)Solutiile (in Prolog) se vor afisa in ordinea descrescatoare a factorului de certitudine.

(0.5)Raspunsurile la intrebari permit existenta unui factor de certitudine

(0.5)Este obligatoriu sa puteti afisa demonstratia pentru raspunsurile date.





Cerinte generale interfata grafica:

Pentru interfata grafica: va exista un buton de reset, vizibil in orice stadiu
 al aplicatiei, care, la click, va reseta aplicatia la primul ecran, si va
 reseta si baza de cunostinte in Prolog, pentru a se permite o noua consultare.





regulile vor avea formatul (ceea ce e scris cu gri e doar comentariu, nu face parte din format): 
selecteaza textul
regula nr%%id (unde id este numarul regulii)
atribut_concluzie %% valoare fact certitudine %% nr (concluzia; nr este factorul de certitudine)
enum conditii (conditiile intre acolade, atributele separate cu virgula)
     [atr%%valoare], (pentru atribute cu valori multiple)
     [atr],(pentru atribute booleene, valoare true)
     [not atr] (pentru atribute booleene, valoare false)
.


intrebarile vor avea formatul: 
selecteaza textul
intrebare [atribut ; 
text: 'continut intrebare' ;
variante : [val1 ; val2 ; val3 ; ...] ].


scopul se va defini: 
selecteaza textul
scop%%atr


Programul va folosi un director numit log_witcher3 (daca exista, il va folosi
 pe acela, iar daca nu exista, il va crea). In acest folder va exista un fisier 
log.txt corespunzator consultarii curente in care se va afisa pentru fiecare 
atribut in parte a carui valoare a fost ceruta utilizatorului de catre sistemul
 expert (adica atributele pentru care s-a pus o intrebare) de ce a fost ceruta,
in felul urmator:
se va afisa numele atributului.
sub atribut se va afisa regula care a avut nevoie de el. Regula se va afisa in
 acelasi format pe care il avea in fiserul de input si pe care il are in
 fisierele de demonstratii.




Veti crea cate un fisier numit demonstratie_personaj=solutie.txt pentru fiecare
 solutie in parte. Cuvantul solutie din numele fisierului va fi inlocuit cu 
valoarea solutiei In fiecare fisier primul rand va fi de forma: "Demonstratie 
pentru personaj=solutie cu factor de certitudine fc". Cuvantul solutie din
 aceasta fraza va fi inlocuit cu valoarea solutiei, iar fc cu factorul de 
certitudine. Dupa acest rand urmeaza demonstratia pentru acea solutie.


In demonstratii, afisarea regulilor se va face exact in forma in care au fost 
scrise in fisierul de intrare.: 
selecteaza textul
regula nr%%id (unde id este numarul regulii)
atribut_concluzie %% valoare fact certitudine %% nr (concluzia; nr este factorul de certitudine)
enum conditii (conditiile intre acolade, atributele separate cu virgula)
     [atr%%valoare], (pentru atribute cu valori multiple)
     [atr],(pentru atribute booleene, valoare true)
     [not atr] (pentru atribute booleene, valoare false)
.

Forma de afisare a celorlalte tipuri de informatii din demonstratie se lasa la alegerea studentilor.







Cerinte interfata grafica:

Intrebarile vor fi afisate pe rand in aceeasi fereastra. 
Pentru optiuni, indiferent de tipul de intrebare, veti folosi JToogleButtons. 
Cand unul este activat, automat se dezactiveaza toate celalalte. 
Cel activat isi va schimba culoarea de background in galben, iar la dezactivare 
va reveni la background-ul initial. Pentru factorul de certitudine va exista un
 JLabel cu doua butoane mici langa el 
(unul pe care scrie + si unul pe care scrie -). La click pe plus va creste 
numarul din label cu 10, pana la maxim 100. La click pe minus, numarul se 
va micsora cu 10 pana la minim 0. Va exista si un buton cu textul 
"am raspuns la intrebare" care, la click pe el, va lua in considerare 
raspunsul dat si va trece la urmatoarea intrebare.


Pentru fiecare intrebare va exista si un buton cu textul "De ce vrei sa stii?",
 care, la click pe el, va afisa intr-o fereastra noua istoricul referitor la 
atributul intrebarii curente. Istoricul se va afisa exact ca in fisierul
log_witcher3.txt.


Sub intrebare si optiuni va exista si un JScrollPane in care, pe masura ce se
 raspunde la cate o intrebare, adauga, pe verticala, cate un JLabel cu textul
 intrebarii la care s-a raspuns si raspunsul dat de utilizator. 
Fiecare doua astfel de JLabel-uri vor fi separate cu ajutorul unui JSeparator.


La final, se vor afisa, unul sub altul, intr-un ScrollPane, folosind cate un
 JLabel pentru fiecare, raspunsurile cu factorii de certitudine. Sub fiecare 
raspuns va fi o imagine reprezentativa pentru personaj si un JTextPane cu 
demonstratia pentru acel raspuns. Doua raspunsuri vor fi separate cu ajutorul 
cate unui JSeparator de culoare albastra.