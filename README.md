# Sales Tax Problem
## Problem Statement
```
PROBLEM ONE : SALES TAXES
Basic sales tax is applicable at a rate of 10% on all goods, except books, food,
and medical products that are exempt. Import duty is an additional sales tax
applicable on all imported goods at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the items
and their price (including tax), finishing with the total cost of the items,
and the total amounts of sales taxes paid.  The rounding rules for sales tax are
that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to
the nearest 0.05) amount of sales tax.

Write an application that prints out the receipt details for these shopping baskets...
INPUT:
Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25

OUTPUT
Output 1:
1 book: 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83

Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15

Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68
```

## About the solution

Solution is a close simulation of the output of a 1-2 hour pairing interview.
It is definitely not the most ideal solution nor the most elegant solution.
If anything, it is just a simple but expandable (through refactoring protected by tests) solution.

TDD was utilised to arrive to the final solution.
The starting point chosen (implement `Item`) was because it was the "most familiar" part of the problem.

The git log are intentionally verbose to allow reader of this repo to follow through how the code evolves.

`int` was chosen instead of `double` to avoid rounding problems when performing multiplications and divisions.

## Potential improvements

- Better parsing of item to different types (a separate Parser class?)
- Read input from file, output to file/stdout
- Better handling of tax exemption (instead of violating OCP)
- Better handling of different taxes (instead of violating OCP)
