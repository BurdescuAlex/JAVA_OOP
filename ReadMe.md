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
