
:-use_module(library(lists)).
:-use_module(library(system)).
:-use_module(library(file_systems)).
:-op(900,fy,not).
:-dynamic fapt/3.
:-dynamic interogat/1.
:-dynamic scop/1.
:-dynamic interogabil/3.
:-dynamic regula/3.
:-discontiguous citeste_cuvant/3.

%  #############################################    COMMUNICATION    ################################################3

:-use_module(library(sockets)).

% flash output curata buffer-ul. trebuie apelat imediat dupa un write.
inceput:-format('Salutare\n',[]),	flush_output,
				prolog_flag(argv, [PortSocket|_]), %preiau numarul portului, dat ca argument cu -a
				% portul este atom, nu constanta numerica, asa ca trebuie sa il convertim la numar
				% trebuie transformat portul din string in int
				atom_chars(PortSocket,LCifre),
				number_chars(Port,LCifre),%transforma lista de cifre in numarul din 
				
				% aici se deschiide conexiunea spre interfata pe localhost si portul obtinut
				% se scrie si se citeste pe acelasi stream si se trimite text
				socket_client_open(localhost: Port, Stream, [type(text)]),
				
				% asta citeste si procezeaza cate o comanda
				proceseaza_text_primit(Stream,0).
				
				
proceseaza_text_primit(Stream,C):-
				% citim de pe stream (trebuie sa pui punct dupa fiecare comanda)
				read(Stream,CevaCitit),
				proceseaza_termen_citit(Stream,CevaCitit,C).
				
% C numara numarul de comenzi date(incepe de la 0 mai sus)			

proceseaza_termen_citit(Stream,salut,C):-
				% daca am citit salut, se intra pe ramura asta si raspunde cu salut bre
				write(Stream,'salut, bre!\n'),
				flush_output(Stream),
				C1 is C+1,
				proceseaza_text_primit(Stream,C1).
				
proceseaza_termen_citit(Stream,'ce mai faci?',C):-
				write(Stream,'ma plictisesc...\n'),
				flush_output(Stream),
				C1 is C+1,
				proceseaza_text_primit(Stream,C1).
				
proceseaza_termen_citit(Stream, X + Y,C):-
				Rez is X+Y,
				write(Stream,Rez),nl(Stream),
				flush_output(Stream),
				C1 is C+1,
				proceseaza_text_primit(Stream,C1).
				
oras(bucuresti, mare).				
oras(pitesti, mic).
proceseaza_termen_citit(Stream, oras(X),C):-
				oras(X,Tip),
				format(Stream,'~p este un oras ~p\n',[X,Tip]),
				flush_output(Stream),
				C1 is C+1,
				proceseaza_text_primit(Stream,C1).
				
proceseaza_termen_citit(Stream, X, _):-
				(X == end_of_file ; X == exit),
				close(Stream).
				
proceseaza_termen_citit(Stream, comanda(incarca(F)), C):-
				nl, nl,
				write(F), nl, nl, nl,
				incarca(Stream, F),
				flush_output(Stream),
				C1 is C + 1,
				proceseaza_text_primit(Stream, C1)
				.
	
			
proceseaza_termen_citit(Stream, Altceva,C):-
				write(Stream,'nu inteleg ce vrei sa spui: '),write(Stream,Altceva),nl(Stream),
				flush_output(Stream),
				C1 is C+1,
				proceseaza_text_primit(Stream,C1).



%  #############################################    COMMUNICATION    ################################################3


tab(N) :- N>0,N1 is N-1, write(' '), tab(N1).
tab(0).

not(P):-P,!,fail.
not(_).

scrie_lista([]):-nl.
scrie_lista([H|T]) :-
	write(H), tab(1),
	scrie_lista(T).
             
afiseaza_fapte :-
	write('Fapte existente în baza de cunostinte:'),
	nl,nl, write(' (Atribut,valoare) '), nl,nl,
	listeaza_fapte,nl.

listeaza_fapte:-  
	fapt(av(Atr,Val),FC,_), 
	write('('),write(Atr),write(','),
	write(Val), write(')'),
	write(','), write(' certitudine '),
	FC1 is integer(FC),write(FC1),
	nl,fail.
	listeaza_fapte.

lista_float_int([],[]).
lista_float_int([Regula|Reguli],[Regula1|Reguli1]):-
	(Regula \== utiliz,
	Regula1 is integer(Regula);
	Regula ==utiliz, Regula1=Regula),
	lista_float_int(Reguli,Reguli1).

pornire :-
	retractall(interogat(_)),
	retractall(fapt(_, _, _)),
	repeat,
	write('Introduceti una din urmatoarele optiuni: '),
	nl,nl,
	write(' (Incarca Consulta Reinitiaza  Afisare_fapte  Cum   Iesire) '),
	nl,nl,write('|: '),citeste_linie([H | T]),
	executa([H | T]), H == iesire.

	
executa([incarca]) :- 
	incarca,!,nl, % predicatul incarca citeste fisierul. Cut-ul s-a pus ca sa nu mai treaca la celelalte optiuni
	write('Fisierul dorit a fost incarcat'),nl.
executa([consulta]) :- 
	scopuri_princ,!.
executa([reinitiaza]) :- 
	retractall(interogat(_)),
	retractall(fapt(_,_,_)),!.
executa([afisare_fapte]) :-
	afiseaza_fapte,!.
executa([cum|L]) :- cum(L),!.
executa([iesire]):-!.
executa([_|_]) :-
	write('Comanda incorecta! '),nl.

scopuri_princ :-
	scop(Atr),determina(Atr), afiseaza_scop(Atr),fail.
scopuri_princ.

determina(Atr) :-
	realizare_scop(av(Atr,_),_,[scop(Atr)]),!.
determina(_).

afiseaza_scop(Atr) :-
	nl,fapt(av(Atr,Val),FC,_),
	FC >= 20,scrie_scop(av(Atr,Val),FC),
	nl,fail.
afiseaza_scop(_):- nl,nl.

scrie_scop(av(Atr,Val),FC) :-
	transformare(av(Atr,Val), X),
	scrie_lista(X),tab(2),
	write(' '),
	write('factorul de certitudine este '),
	FC1 is integer(FC),write(FC1).

realizare_scop(not Scop,Not_FC,Istorie) :-
	realizare_scop(Scop,FC,Istorie),
	Not_FC is - FC, !.
realizare_scop(Scop,FC,_) :-
	fapt(Scop,FC,_), !.
realizare_scop(Scop,FC,Istorie) :-
	pot_interoga(Scop,Istorie),
	!,realizare_scop(Scop,FC,Istorie).
realizare_scop(Scop,FC_curent,Istorie) :-
	fg(Scop,FC_curent,Istorie).
	
fg(Scop,FC_curent,Istorie) :-
	regula(N, premise(Lista), concluzie(Scop,FC)),
	demonstreaza(N,Lista,FC_premise,Istorie),
	ajusteaza(FC,FC_premise,FC_nou),
	actualizeaza(Scop,FC_nou,FC_curent,N),
	FC_curent == 100,!.
fg(Scop,FC,_) :- fapt(Scop,FC,_).

pot_interoga(av(Atr,_),Istorie) :-
	not interogat(av(Atr,_)),
	interogabil(Atr,Optiuni,Mesaj),
	interogheaza(Atr,Mesaj,Optiuni,Istorie),nl,
	asserta( interogat(av(Atr,_)) ).

cum([]) :- write('Scop? '),nl,
	write('|:'),citeste_linie(Linie),nl,
	transformare(Scop,Linie), cum(Scop).
cum(L) :- 
	transformare(Scop,L),nl, cum(Scop).
cum(not Scop) :- 
	fapt(Scop,FC,Reguli),
	lista_float_int(Reguli,Reguli1),
	FC < -20,transformare(not Scop,PG),
	append(PG,[a,fost,derivat,cu, ajutorul, 'regulilor: '|Reguli1],LL),
	scrie_lista(LL),nl,afis_reguli(Reguli),fail.
cum(Scop) :-
	fapt(Scop,FC,Reguli),
	lista_float_int(Reguli,Reguli1),
	FC > 20,transformare(Scop,PG),
	append(PG,[a,fost,derivat,cu, ajutorul, 'regulilor: '|Reguli1],LL),
	scrie_lista(LL),nl,afis_reguli(Reguli),
	fail.
cum(_).

afis_reguli([]).
afis_reguli([N|X]) :-
	afis_regula(N),
	premisele(N),
	afis_reguli(X).
afis_regula(N) :-
	% primul parametru este ........
	regula(	N, premise(Lista_premise),concluzie(Scop, FC)),
	NN is integer(N),
	scrie_lista(['regula  ',NN]),
	scrie_lista(['  Daca']),
	scrie_lista_premise(Lista_premise),
	scrie_lista(['  Atunci']),
	transformare(Scop,Scop_tr),
	append(['   '],Scop_tr,L1),
	FC1 is integer(FC),append(L1,[FC1],LL),
	scrie_lista(LL),nl.

scrie_lista_premise([]).
scrie_lista_premise([H|T]) :-
	transformare(H,H_tr),
	tab(5),scrie_lista(H_tr),
	scrie_lista_premise(T).

transformare(av(A,da),[A]) :- !.
transformare(not av(A,da), [not,A]) :- !.
transformare(av(A,nu),[not,A]) :- !.
transformare(av(A,V),[A,este,V]).

premisele(N) :-
	regula(N, premise(Lista_premise), _),
	!, cum_premise(Lista_premise).
	
cum_premise([]).
cum_premise([Scop|X]) :-
	cum(Scop),
	cum_premise(X).
	
interogheaza(Atr,Mesaj,[da,nu],Istorie) :-
	!,write(Mesaj),nl,
	de_la_utiliz(X,Istorie,[da,nu]),
	det_val_fc(X,Val,FC),
	asserta( fapt(av(Atr,Val),FC,[utiliz]) ).
interogheaza(Atr,Mesaj,Optiuni,Istorie) :-
	write(Mesaj),nl,
	citeste_opt(VLista,Optiuni,Istorie),
	assert_fapt(Atr,VLista).

citeste_opt(X,Optiuni,Istorie) :-
	append(['('],Optiuni,Opt1),
	append(Opt1,[')'],Opt),
	scrie_lista(Opt),
	de_la_utiliz(X,Istorie,Optiuni).

de_la_utiliz(X,Istorie,Lista_opt) :-
	repeat,write(': '),citeste_linie(X),
	proceseaza_raspuns(X,Istorie,Lista_opt).

proceseaza_raspuns([de_ce],Istorie,_) :- nl,afis_istorie(Istorie),!,fail.

proceseaza_raspuns([X],_,Lista_opt):-
	member(X,Lista_opt).
proceseaza_raspuns([X,fc,FC],_,Lista_opt):-
	member(X,Lista_opt),float(FC).

assert_fapt(Atr,[Val,fc,FC]) :-
	!,asserta( fapt(av(Atr,Val),FC,[utiliz]) ).
assert_fapt(Atr,[Val]) :-
	asserta( fapt(av(Atr,Val),100,[utiliz])).

det_val_fc([nu],da,-100).
det_val_fc([nu,FC],da,NFC) :- NFC is -FC.
det_val_fc([nu,fc,FC],da,NFC) :- NFC is -FC.
det_val_fc([Val,FC],Val,FC).
det_val_fc([Val,fc,FC],Val,FC).
det_val_fc([Val],Val,100).
	
afis_istorie([]) :- nl.
afis_istorie([scop(X)|T]) :-
	scrie_lista([scop,X]),!,
	afis_istorie(T).
afis_istorie([N|T]) :-
	afis_regula(N),!,afis_istorie(T).

demonstreaza(N,ListaPremise,Val_finala,Istorie) :-
	dem(ListaPremise,100,Val_finala,[N|Istorie]),!.

dem([],Val_finala,Val_finala,_).
dem([H|T],Val_actuala,Val_finala,Istorie) :-
	realizare_scop(H,FC,Istorie),
	Val_interm is min(Val_actuala,FC),
	Val_interm >= 20,
	dem(T,Val_interm,Val_finala,Istorie).
 
actualizeaza(Scop,FC_nou,FC,RegulaN) :-
	fapt(Scop,FC_vechi,_),
	combina(FC_nou,FC_vechi,FC),
	retract( fapt(Scop,FC_vechi,Reguli_vechi) ),
	asserta( fapt(Scop,FC,[RegulaN | Reguli_vechi]) ),!.
actualizeaza(Scop,FC,FC,RegulaN) :-
	asserta( fapt(Scop,FC,[RegulaN]) ).

ajusteaza(FC1,FC2,FC) :-
	X is FC1 * FC2 / 100,
	FC is round(X).
combina(FC1,FC2,FC) :-
	FC1 >= 0,FC2 >= 0,
	X is FC2*(100 - FC1)/100 + FC1,
	FC is round(X).
combina(FC1,FC2,FC) :-
	FC1 < 0,FC2 < 0,
	X is - ( -FC1 -FC2 * (100 + FC1)/100),
	FC is round(X).
combina(FC1,FC2,FC) :-
	(FC1 < 0; FC2 < 0),
	(FC1 > 0; FC2 > 0),
	FCM1 is abs(FC1),FCM2 is abs(FC2),
	MFC is min(FCM1,FCM2),
	X is 100 * (FC1 + FC2) / (100 - MFC),
	FC is round(X).

incarca :-
	write('Introduceti numele fisierului care doriti sa fie incarcat: '),nl, write('|:'),read(F),
	file_exists(F), !, incarca_prolog(F).  % daca exista fisierul si e totul okey, il incarca
incarca :-
	write('Nume incorect de fisier! '),nl,fail.
	
incarca_prolog( F) :-
	retractall(interogat(_)),retractall(fapt(_, _, _)),
	retractall(scop(_)),retractall(interogabil(_, _, _)),
	retractall(regula(_, _, _)),
	see(F),incarca_reguli, seen, !. % see citeste din fisier. seen inchide fisierul
	

% interograt si fapt a explicat deja cica
% scop memoreaza atributul scop
% interogabil memoreaza intrebarile. primul parametru este atributul. al doilea e lista de optiuni. al treilea este intrebarea in sine
incarca(Stream, F) :-
	retractall(interogat(_)),retractall(fapt(_, _, _)),
	retractall(scop(_)),retractall(interogabil(_, _, _)),
	retractall(regula(_, _, _)),
	see(F),incarca_reguli, seen, !, write(Stream, 'ok\n'). % see citeste din fisier. seen inchide fisierul
	
incarca(Stream, _):-
	write(Stream, 'eroare_incarcare\n')
	.

incarca_reguli :-
	repeat, citeste_propozitie(L),		% citeste linie citea pana la \n. citeste propozitie citeste pana la .
	proceseaza(L), L == [end_of_file], nl.  % proceseaza e cel care interpreteaza informatia citita

proceseaza([end_of_file]):-!.  % daca sunt la final, pa
proceseaza(L) :-
	% fiecare propozitie se transforma intr-un fapt
	% trad: in R pune faptul pe care trebuie sa il assertam 
	% foloseste assertz pentru a le pune fix in ordinea in care sunt citite
	trad(R,L,[]), write(R), nl, assertz(R), !. 
	
% reguli DCG  - reguli speciale de parsare
% predicat care face propozitii de tip: subiect predicat complement
% articol + subs = subiect; predicat = verb; complement = prepozitie + substantiv
% deci trad asta stie ca daca ii vine o propozitie de genul scopul este [ceva], atunci [ceva] e returnat in X
% scop(X) este R-ul de mai sus. Deci R este scop de X daca trad se descompune in 'scopul este ............'
trad(scop(X)) --> [scop, '%', '%', X].
trad(scop(X)) --> [scop,X].
trad(interogabil(Atr, M, P)) --> 
	% daca este intrebare:
	% intreaba atributul cu o lista de optiuni si mesajul de afisare
	[intrebare, '[', Atr, ';'], afiseaza(Atr, P), lista_optiuni(M).
% trad (ID, [per(atribut, val) ....], 'Atunci [concluzie] fc [F]')
trad(regula(N, premise(Daca), concluzie(Atunci, F))) --> 
	identificator(N), atunci(Atunci, F), daca(Daca).
trad('Eroare la parsare' - L, L, _).

% lista_optiuni de descompune in cuvantul optiuni si paranteza
% lista_de_optiuni itereaza prin optiuni
% cat timp lista nu se unifica cu [element, ')'], se citeste
% recursiv.
lista_optiuni(M) --> [variante,':'],lista_de_optiuni(M).
lista_de_optiuni([Element]) -->  [Element,']', ']'].
lista_de_optiuni([Element|T]) --> [Element, ';'], lista_de_optiuni(T).

afiseaza(_, P) -->  [text, ':', P, ';'].
afiseaza(P, P) -->  [].
% asta ia ID-ul unei reguli
identificator(N) --> [regula, nr, '%', '%', N].

% asta ia partea ca daca din premise si ia toata premizele
daca(Daca) --> [enum, conditii],lista_premise(Daca).

% pot pune premize cu si sau cu , intre ele
% propz ia prima pereche de atribut valoare si ia lista premizelor
% lista_premise([Prima|Celalalte]) --> propoz(Prima),[']', ',', '['],lista_premise(Celalalte).
lista_premise([Prima|Celalalte]) --> propoz(Prima),[','],lista_premise(Celalalte).

% se opreste cand intalnesti termenul atunci, altfel
% ia premizele, le baga in lista si apeleaza recursiv
lista_premise([Daca]) --> propoz(Daca), ['.'].

% atunci merge pana gaseste factorul de certitudine
atunci(Atunci,FC) --> propoz(Atunci),[fact, certitudine, '%', '%'],[FC].
% daca lipsteste factorul de certitudine, il pune automat 100
atunci(Atunci,100) --> propoz(Atunci).

% asta ia bucatile din premize de tipul 
% not ceva
% ceva este altceva
% ceva
propoz(not av(Atr,da)) --> [not, Atr].  % il memoreaza ca fiind not(Atr, da). Puteam sa il memoram si ca (Atr, nu).
propoz(av(Atr,Val)) --> [Atr, '%', '%', Val].  % valori multiple ale atributului
propoz(av(Atr,da)) --> [Atr].
propoz(av(Atr,Val)) --> ['[', Atr, '%', '%', Val, ']'].
propoz(not av(Atr,da)) --> ['[', not, Atr, ']'].  
propoz(av(Atr,da)) --> ['[', Atr, ']'].

citeste_linie([Cuv | Lista_cuv]) :-
	get_code(Car),
	citeste_cuvant(Car, Cuv, Car1), 
	rest_cuvinte_linie(Car1, Lista_cuv). 
      
% -1 este codul ASCII pt EOF

rest_cuvinte_linie(-1, []):- !.    
rest_cuvinte_linie(Car,[]) :- (Car==13;Car==10), !.
rest_cuvinte_linie(Car,[Cuv1|Lista_cuv]) :-
	citeste_cuvant(Car,Cuv1,Car1),      
	rest_cuvinte_linie(Car1,Lista_cuv).

citeste_propozitie([Cuv | Lista_cuv]) :-
	get_code(Car), citeste_cuvant(Car, Cuv, Car1), % citeste un cuvant si apeleaza rest_cuvinte_propozitie
	rest_cuvinte_propozitie(Car1, Lista_cuv). 
     
% aici suntem in fisier, deci daca citim -1, atunci suntem la EOF
rest_cuvinte_propozitie(-1, []):- !.    
rest_cuvinte_propozitie(Car, []) :- Car == 46, !. % daca e punct, returnam lista vida pentru ca e finalul propozitiei
rest_cuvinte_propozitie(Car,[Cuv1|Lista_cuv]) :-   % altfel pun caracterul in lista si continui citirea de caractere
	citeste_cuvant(Car,Cuv1,Car1),      
	rest_cuvinte_propozitie(Car1,Lista_cuv).

citeste_cuvant(-1, end_of_file, -1):- !.
citeste_cuvant(Caracter, Cuvant, Caracter1) :-   
	caracter_cuvant(Caracter), !, 
	name(Cuvant, [Caracter]), get_code(Caracter1).
citeste_cuvant(Caracter, Numar, Caracter1) :-
	caracter_numar(Caracter), !,
	citeste_tot_numarul(Caracter, Numar, Caracter1). 

citeste_tot_numarul(Caracter,Numar,Caracter1):-
	determina_lista(Lista1,Caracter1),
	append([Caracter],Lista1,Lista),
	transforma_lista_numar(Lista,Numar).

determina_lista(Lista,Caracter1):-
	get_code(Caracter), 
	(caracter_numar(Caracter),
	determina_lista(Lista1, Caracter1),
	append([Caracter], Lista1, Lista); 
	\+(caracter_numar(Caracter)),
	Lista=[],Caracter1 = Caracter). 

transforma_lista_numar([], 0).
transforma_lista_numar([H|T], N):-
	transforma_lista_numar(T, NN), 
	lungime(T, L), Aux is 10**L,
	HH is H-48,N is HH*Aux+NN.

lungime([],0).
lungime([_|T],L):-
	lungime(T,L1),
	L is L1+1.

% 39 este codul ASCII pt ghilimea

citeste_cuvant(Caracter, Cuvant, Caracter1):-
	Caracter == 39, !,
	pana_la_urmatorul_apostrof(Lista_caractere),
	L = [Caracter|Lista_caractere],
	name(Cuvant, L), get_code(Caracter1).        

pana_la_urmatorul_apostrof(Lista_caractere):-
	get_code(Caracter),
	(Caracter == 39,Lista_caractere=[Caracter];
	Caracter\==39,
	pana_la_urmatorul_apostrof(Lista_caractere1),
	Lista_caractere=[Caracter|Lista_caractere1]).

citeste_cuvant(Caracter, Cuvant, Caracter1):-          
	caractere_in_interiorul_unui_cuvant(Caracter),!,              
	((Caracter > 64, Caracter < 91), !,
	Caracter_modificat is Caracter + 32;
	Caracter_modificat is Caracter),                              
	citeste_intreg_cuvantul(Caractere, Caracter1), % optinem o lisat de coduri ascii
	name(Cuvant, [Caracter_modificat | Caractere]).  % transforma lista de coduri ascii in atom      

citeste_intreg_cuvantul(Lista_Caractere, Caracter1):-
	get_code(Caracter),  %citim un caracter
	(caractere_in_interiorul_unui_cuvant(Caracter), % verificam ca e caracter valid
	((Caracter > 64, Caracter < 91),!,  % daca e litera mare, il facem litera mica
	Caracter_modificat is Caracter + 32;
	Caracter_modificat is Caracter),
	citeste_intreg_cuvantul(Lista_Caractere1, Caracter1),  % apeleaza recursiv
	Lista_Caractere = [Caracter_modificat | Lista_Caractere1];
	\+ (caractere_in_interiorul_unui_cuvant(Caracter)), % daca nu e caracter valid, orpim recursivitatea
	Lista_Caractere = [], Caracter1 = Caracter).

% daca nu intra pe niciunul din celelalte cazuri, sare peste caracter
citeste_cuvant(_, Cuvant, Caracter1):-                
	get_code(Caracter),       
	citeste_cuvant(Caracter, Cuvant, Caracter1). 

% aici specificam ce alte caractere mai pot fi luate ca un cuvant intreg
% 91 = [   
% 93 = ]
% 37 = %
% 44 = ,
% 59 = ;
% 46 = .
caracter_cuvant(C):-member(C, [44, 59, 58, 63, 33, 46, 41, 40, 37, 91, 93]).

% am specificat codurile ASCII pentru , ; : ? ! . ) (

caractere_in_interiorul_unui_cuvant(C):-
	C > 64, C < 91; C > 47, C < 58;
	C == 45; C == 95; C > 96, C < 123.
caracter_numar(C):-C < 58, C >= 48.