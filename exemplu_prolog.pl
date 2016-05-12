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
				
			
proceseaza_termen_citit(Stream, Altceva,C):-
				write(Stream,'nu inteleg ce vrei sa spui: '),write(Stream,Altceva),nl(Stream),
				flush_output(Stream),
				C1 is C+1,
				proceseaza_text_primit(Stream,C1).