BALAN GIORGIANA-LAVINIA - 321CB

								Tema 1 POO
	

	Tema mea contine 11 fisiere.
->	In clasa Main am metoda main in care deschid fisierul de input si citesc
datele de intrare linie cu linie si scriu rezultatele in fisierul de output.
	Dupa ce am citit datele de intrare imi creez un cache de tipul cerut in 
fisierul de input si o memorie principala si determin tipul de operatie
de pe fiecare linie. 
	Pentru operatia ADD creez un nou obiect de tip Subscriptie
cu atributele delimitate din fisier si il adaug in memorie daca nu exista.
Daca exista in memorie il suprascriu, iar daca acesta exista si in cache il
elimin.
	In operatia GET verific unde exista obiectul, fac operatiile necesare de
mutare in cache si afisez rezultatele in fisierul de output.

->	In clasa Memory folosesc o lista de tip ArrayList pentru a tine evidenta
obiectelor din memoria principala. 
	Aceasta clasa contine metoda pentru adaugarea unui element in lista (daca 
elementul exista deja, el va fi suprascris).
	Metoda search returneaza adevarat sau fals la apartenenta obiectului in
memorie.
	Metoda obtain imi returneaza obiectul din memorie cu numele cautat.
	
->	Clasa abstracta Subscriptie contine numele fiecarui obiect si doua metode
abstracte pentru a fi implementate de Free, Basic si Premium.

->	Clasa Free extinde clasa Subscriptie si construieste un obiect daca nu
exista cereri basic sau premium. Aceasta clasa contine metoda de intoarcere
a tipului de subscriptie curent.

->	Clasa Basic extinde clasa Free si contine metoda pentru determinarea
tipului de subscriptie curent.
	Metoda consume scade numarul de cereri basic doar daca acesta este pozitiv.
	
->	Clasa Premium extinde clasa Basic si contine aceleasi metode ca si clasa
parinte.

->	Clasa LFUSubscriptie creeaza un nou obiect care contine elementul de tip
Subscriptie si un contor ce tine evidenta numarului de accesari ale fiecarui
obiect. Aceasta clasa este folosita ca un wrapper pentru implementarea tipului
de cache LFU.

->	Interfata Cache contine headerele metodelor care vor fi implementate de
fiecare tip de cache.

->	Clasa LRUCache implementeaza interfata Cache. Am ales un ArrayList pentru
reprezentarea memoriei cache in care adaug elementele noi la final, iar cele
"vechi" raman la inceput pentru a putea fi eliminate mai usor.
	Metoda add verifica daca obiectul de adaugat se afla in cache, iar daca
acesta exista, il actualizeaza mutandu-l la finalul listei (devenind cel mai
recent obiect).
	Daca elementul nu exista se verifica spatiul disponibil. Daca memoria este
plina se apeleaza functia de remove care sterge primul element din lista, si
anume cel mai vechi element, apoi se adauga elementul dorit. Daca lista nu este
plina, obiectul de adauga la finalul listei.
	Metoda remove, asa cum am spus mai sus, sterge primul element din lista
deoarece acesta este cel mai vechi.
	Metoda removeObject cauta in cache obiectul si il sterge daca se afla in
lista.
	Metoda search returneaza true daca elementul se gaseste in lista si false
altfel.
	Metoda obtain intoarce elementul cautat din cache.

->	Clasa LFUCache implementeaza interfata Cache. Si pentru acest tip de cache
am ales ArrayList, doar ca acesta contine elemente de tip LFUSubscriptie.
	Metoda add cauta obiectul in cache, iar daca exista ii incrementeaza numarul
de accesari si ajunge la finalul listei pentru a simboliza cel mai recent folosit
obiect (implementarea este aceeasi ca la LRU doar ca se tine cont si de numarul de
accesari ale fiecarui obiect). Daca lista nu contine obiectul se verifica daca exista
loc pentru unul nou. Daca nu exista atunci se apeleaza functia remove pentru
eliminarea elementului cel mai putin folosit. Elementul nou se va adauga in lista
la final.
	Metoda remove sterge elementul cu cele mai putine accesari. Daca exista doua sau
mai multe elemente cu acelasi numar de accesari se va sterge cel mai vechi deoarece
elementele cele mai vechi sunt pe pozitiile cele mai mici, iar elementele cele mai
noi sunt pe pozitii mai mari.
	Metoda removeObject sterge elementul cu numele dat ca parametru (daca exista in
cache).
	Metodele search si obtain se comporta la fel ca cele de la LRU.
	
->	Clasa FIFOCache implementeaza interfata Cache. De asemenea si aici este folosit
ArrayList pentru implementarea cache-ului.
	Metoda add adauga obiectul in lista. Daca obiectul exista deja in cache atunci
nu se va adauga sau suprascrie nimic. Daca lista este plina se sterge cu functia
remove primul element din lista (reprezinta coada). Dupa verificari se adauga elementul
la sfarsitul listei.
	Metoda remove sterge primul element din lista.
	Metodele remove, search si obtain se comporta la fel ca si cele din LRU si LFU.


