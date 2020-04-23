# Etapa1 Proiect JAVA Softwere Casa de Marcat

## Clase implmentate:

* Products: Clasa abstracata. Contine campuri pentru: Id, nume, pret. De asemena un counter static pentru incrementarea Id-urilor.
  * Food: Cotine campuri pentru a verifica daca este mancare expirata si data expirarii.
  * Electronics: Contine campuri pentru garantie si costul livrarii.
  * Furniture: Contine campuri pentru costul livrarii si daca vrei/nu vrei livrare.

* Employees: Clasa abstracata. Contine campuri pentru: Id, nume, salariu. De asemenea un counter static pentru incrementarea Id-urilor.
  * Cashier: Contine campul experience, pentru bonusuri salariale.
  * CashRegisterSpecialist: Contine campurile loginID, loginPass pentru a putea face modificari in cadrul caselor de marcat.

* Payments: Clasa abstracata. Contine campuri pentru Id, data la care s-a facut paymentul si un obiect de timp ShoppingCart. De asemenea un counter static pentru incrementarea Id-urilor.
  * Cash: Contine campuri pentru cat este nevoie de platit, cat a platit si ce rest s-a dat
  * Card: Contine campuri pentru cat s-a platit si numarul cardului

* ShoppingCart: Clasa ce contine un vector de produse. 

## Servicii implmentate:

* ProductService - Contine metodele: addProduct(), seeProducts(), removeProduct(), findProduct(), getProducts()
* EmployeeService - Contine metodele: addEmployee(), fireEmployee(), seeEmployees(), seeFiredEmployees(), findEmployee(), getEmployees()
* PaymentsService - Contine metodele: addPayment(), seePayments(), removePayment(), findPayment(), getPayments()

# Etapa2

## Servicii implmentate:

* ProductServiceIO - Citeste si scrie datele in fisierele Food.csv , Electronics.csv, Furniture.csv
* EmployeeServiceIO - Citeste si scrie datele in fisierele Cashier.csv, CashRegisterSpecialist.csv., FiredEmployees.csv
* PaymentsServiceIO - Citeste si scrie datele in fisierele Cash.csv, Card.csv
* AuditService - Scrie loguri pentru sesiunea de lucru in Log.txt

## Buguri si Probleme rezolvate:

* Rezolvare probleme de eliminare a obiectelor din repository-urilor in care acestea nu se eliminau cum trebuie
* Rezolvare problema la payments in care se copia o referinta a ShoppingCart-ului, nu a elementelor din el

## Functii noi adaugate

* Adaugare functii de addProduct(s), addPayment(s), addEmployee(s), addFiredEmpployee(s) care accepta ca parametru un vector
