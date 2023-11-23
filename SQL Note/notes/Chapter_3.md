# [SQL Note](../README.md) - Chapter 3 Query Primer
| Chapter | Title |
| :-: | :- |
| 3.1 | [Query Clauses](#31-query-clauses) |
| 3.2 | [SELECT Clause](#32-select-clause) |
| 3.3 | [FROM Clauses](#33-from-clauses) |
| 3.4 | [WHERE Clause](#34-where-clause) |
| 3.5 | [GROUP BY and HAVING Clauses](#35-group-by-and-having-clauses) |
| 3.6 | [ORDER BY Clause](#36-order-by-clause) |

<br>

## 3.1 Query Clauses
| Clause Name | Purpose |
| :-- | :-- |
| SELECT | Determines which columns to include in the query’s result set |
| FROM | Identifies the tables from which to retrieve data and how the tables should be joined |
| WHERE | Filters out unwanted data |
| GROUP BY | Used to group rows together by common column values |
| HAVING | Filters out unwanted groups |
| ORDER BY | Sorts the rows of the final result set by one or more columns |

<br>

## 3.2 SELECT Clause
### Selecting All Columns
```sql
SELECT *
FROM language;
```

### Selecting Single Column
```sql
SELECT name
FROM language;
```

### Selecting Multiple Columns
```sql
SELECT language_id, name, last_update
FROM language;
```

### Column Aliases
```sql
SELECT language_id,
    'COMMON' language_usage,
    language_id * 3.1415927 lang_pi_value,
    upper(name) language_name
FROM language;
```
```sql
SELECT language_id,
    'COMMON' AS language_usage,
    language_id * 3.1415927 AS lang_pi_value,
    upper(name) AS language_name
FROM language;
```

### Column Expressions
```sql
SELECT language_id,
    'COMMON' language_usage,
    language_id * 3.1415927 lang_pi_value,
    upper(name) language_name
FROM language;
```
```sql
SELECT version(),
    user(),
    database();
```

### Removing Duplicates
```sql
SELECT DISTINCT actor_id
FROM film_actor
ORDER BY actor_id;
```

<br>

## 3.3 FROM Clauses
### Types of Tables
1. Permanent tables
2. Derived tables
3. Temporary tables
4. Virtual tables

### Permanent Tables
```sql
SELECT *
FROM language;
```

### Derived Tables
```sql
SELECT concat(cust.last_name, ', ', cust.first_name) full_name
FROM
    (SELECT first_name, last_name, email
    FROM customer
    WHERE first_name = 'JESSIE'
    ) cust;
```

### Temporary Tables
```sql
CREATE TEMPORARY TABLE actors_j
(actor_id smallint(5),
first_name varchar(45),
last_name varchar(45)
);

INSERT INTO actors_j
SELECT actor_id, first_name, last_name
FROM actor
WHERE last_name LIKE 'J%';

SELECT * FROM actors_j;
```

### Virtual Tables
```sql
CREATE VIEW cust_vw AS
SELECT customer_id, first_name, last_name, active
FROM customer;

SELECT first_name, last_name
FROM cust_vw
WHERE active = 0;
```

### Table Links
```sql
SELECT customer.first_name, customer.last_name, time(rental.rental_date) rental_time
FROM customer
    INNER JOIN rental
    ON customer.customer_id = rental.customer_id
WHERE date(rental.rental_date) = '2005-06-14';
```

### Table Aliases
```sql
SELECT c.first_name, c.last_name, time(r.rental_date) rental_time
FROM customer c
    INNER JOIN rental r
    ON c.customer_id = r.customer_id
WHERE date(r.rental_date) = '2005-06-14';
```
```sql
SELECT c.first_name, c.last_name, time(r.rental_date) rental_time
FROM customer AS c
    INNER JOIN rental AS r
    ON c.customer_id = r.customer_id
WHERE date(r.rental_date) = '2005-06-14';
```

<br>

## 3.4 WHERE Clause
### Using AND Operator
```sql
SELECT title
FROM film
WHERE rating = 'G' AND rental_duration >= 7;
```

### Using OR Operator
```sql
SELECT title
FROM film
WHERE rating = 'G' OR rental_duration >= 7;
```

### Using Parentheses
```sql
SELECT title, rating, rental_duration
FROM film
WHERE (rating = 'G' AND rental_duration >= 7)
    OR (rating = 'PG-13' AND rental_duration < 4);
```

<br>

## 3.5 GROUP BY and HAVING Clauses
```sql
SELECT c.first_name, c.last_name, count(*)
FROM customer c
    INNER JOIN rental r
    ON c.customer_id = r.customer_id
GROUP BY c.first_name, c.last_name
HAVING count(*) >= 40;
```

<br>

## 3.6 ORDER BY Clause
### Single Column Sorted By Alphabetical Order
```sql
SELECT c.first_name, c.last_name, time(r.rental_date) rental_time
FROM customer c
    INNER JOIN rental r
    ON c.customer_id = r.customer_id
WHERE date(r.rental_date) = '2005-06-14'
ORDER BY c.last_name;
```

### Multiple Columns Sorted By Alphabetical Order
```sql
SELECT c.first_name, c.last_name, time(r.rental_date) rental_time
FROM customer c
    INNER JOIN rental r
    ON c.customer_id = r.customer_id
WHERE date(r.rental_date) = '2005-06-14'
ORDER BY c.last_name, c.first_name;
```

### Sorted By Ascending Order
- The default is ascending.
```sql
SELECT c.first_name, c.last_name, time(r.rental_date) rental_time
FROM customer c
    INNER JOIN rental r
    ON c.customer_id = r.customer_id
WHERE date(r.rental_date) = '2005-06-14'
RDER BY time(r.rental_date) asc;
```

### Sorted By Descending Order
```sql
SELECT c.first_name, c.last_name, time(r.rental_date) rental_time
FROM customer c
    INNER JOIN rental r
    ON c.customer_id = r.customer_id
WHERE date(r.rental_date) = '2005-06-14'
RDER BY time(r.rental_date) desc;
```

### Sorting via Numeric Placeholders
```sql
SELECT c.first_name, c.last_name, time(r.rental_date) rental_time
FROM customer c
    INNER JOIN rental r
    ON c.customer_id = r.customer_id
WHERE date(r.rental_date) = '2005-06-14'
ORDER BY 3 desc;
```

<br>
