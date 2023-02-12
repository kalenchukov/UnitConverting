# Справка
## UnitConverting
Конвертер величин.

## Поддерживаемые меры измерения
* Информации
* Массы

## Использование
### Мера измерения информации
#### Получение величины информации
```java
InformationQuantity information = new InformationQuantity(1, InformationMeasure.BYTE);
information.getQuantity();
```

Результат выполнения:
```
1
```

#### Получение меры информации
```java
InformationQuantity information = new InformationQuantity(1, InformationMeasure.BYTE);
information.getMeasure();
```

Результат выполнения:
```
BYTE
```

#### Сравнение величины информации
```java
InformationQuantity information = new InformationQuantity(1, InformationMeasure.BYTE);
information.compareTo(new InformationQuantity(1, InformationMeasure.BIT))
```

Результат выполнения:
```
1
```

#### Конвертирование величины информации
```java
InformationQuantity information = new InformationQuantity(1, InformationMeasure.BYTE);
information.convert(InformationMeasure.BIT);
```

Результат выполнения:
```
8
```

#### Сравнение двух величин информации
```java
InformationQuantity.compare(
    new InformationQuantity(1, InformationMeasure.BYTE),
    new InformationQuantity(1, InformationMeasure.BIT)
);
```

Результат выполнения:
```
1
```

#### Меры информации
#### Получение наименьшей меры информации
```java
InformationMeasure.getMin();
```

Результат выполнения:
```
BIT
```

#### Получение наименьшей меры информации по стандарту
```java
InformationMeasure.getMin(Standard.IEC);
```

Результат выполнения:
```
BIT
```

#### Получение наибольшей меры информации
```java
InformationMeasure.getMax();
```

Результат выполнения:
```
YOBIBYTE
```

#### Получение наибольшей меры информации по стандарту
```java
InformationMeasure.getMax(Standard.SI);
```

Результат выполнения:
```
YOTTABYTE
```

### Мера измерение массы
#### Получение величины массы
```java
MassQuantity mass = new MassQuantity(1, MassMeasure.KILOGRAM);
mass.getQuantity();
```

Результат выполнения:
```
1
```

#### Получение меры массы
```java
MassQuantity mass = new MassQuantity(1, MassMeasure.KILOGRAM);
mass.getMeasure();
```

Результат выполнения:
```
KILOGRAM
```

#### Сравнение величины массы
```java
MassQuantity mass = new MassQuantity(1, MassMeasure.KILOGRAM);
mass.compareTo(new MassQuantity(1, MassMeasure.GRAM))
```

Результат выполнения:
```
1
```

#### Конвертирование величины массы
```java
MassQuantity mass = new MassQuantity(1, MassMeasure.KILOGRAM);
mass.convert(MassMeasure.GRAM);
```

Результат выполнения:
```
1000
```

#### Сравнение двух величин массы
```java
MassQuantity.compare(
    new MassQuantity(1, MassMeasure.KILOGRAM),
    new MassQuantity(1, MassMeasure.GRAM)
);
```

Результат выполнения:
```
1
```

#### Меры массы
#### Получение наименьшей меры массы
```java
MassMeasure.getMin();
```

Результат выполнения:
```
YOCTOGRAM
```

#### Получение наименьшей меры массы по стандарту
```java
MassMeasure.getMin(Standard.SI);
```

Результат выполнения:
```
YOCTOGRAM
```

#### Получение наибольшей меры массы
```java
MassMeasure.getMax();
```

Результат выполнения:
```
YOTTAGRAM
```

#### Получение наибольшей меры массы по стандарту
```java
MassMeasure.getMax(Standard.SI);
```

Результат выполнения:
```
YOTTAGRAM
```
