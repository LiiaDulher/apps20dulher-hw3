# Homework 3
### Виконала: Дулгер Лія
## Важливо
В класі Student додано методи equals, hashCode для перевірки рівності 
об'єктів.

В зв'язку з CheckStyle Warnings в початкові файли були внесені
наступні зміни
Назви функцій
````
filterPositiveIntegersSortAndMultiplyBy2
findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname
````
замінені на
````
filterPositiveIntegersSortAndMultiplyByTwo
findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname
````
Також назви змінних замінені в файлах
````
MyComparator.java
SmartArrayApp.java
````
бо цифри не можуть бути в назвах змінних.

Також імпорт
````
import ua.edu.ucu.smartarr.*;
````
замінено на
````
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.DistinctDecorator;
````
через заборону імпорта за допомогою зірочки.

В зв'язку з IllegalTypeCheck в функції
````
filterPositiveIntegersSortAndMultiplyBy2
````
тип повернутих даних з Integer[] змінено на int[], тип необхідних
даних з Integer[] на Object[], а також код
````
return Arrays.copyOf(result, result.length, int[].class);
````
закоментовано та замінено на
````
int[] res = new int[result.length];
for (int i = 0; i < res.length; i++){
    res[i] = (int) result[i];
}
return res;
````
Для виправлення MagicNumberCheck створена константа
````
private static final double GRADE=4.0;
````
Для повного покриття коду тестами створено наступні класи та функції:
````
BaseArrayTest.java
DistinctDecoratorTest.java
SortDecoratorTest.java
MapDecoratorTest.java
FilterDecoratorTest.java
StudentTest.java
TestSmartArrayAppConstructor()
````
Вони є доповненням до основого тесту та самостійно не покривають весь код.