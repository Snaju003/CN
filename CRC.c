#include <stdio.h>
#include <string.h>

void xorOperation(int *temp, int *div, int divisor_len)
{
    for (int i = 0; i < divisor_len; i++)
    {
        temp[i] = temp[i] ^ div[i];
    }
}

int main()
{
    int data[100], divisor[100], temp[100], remainder[100];
    int data_len, divisor_len, total_len;

    // Input data length and data bits
    printf("Enter number of data bits: ");
    scanf("%d", &data_len);
    printf("Enter data bits: ");
    for (int i = 0; i < data_len; i++)
    {
        scanf("%d", &data[i]);
    }

    // Input divisor length and divisor bits
    printf("Enter number of divisor bits: ");
    scanf("%d", &divisor_len);
    printf("Enter divisor bits: ");
    for (int i = 0; i < divisor_len; i++)
    {
        scanf("%d", &divisor[i]);
    }

    // Append zeros to the data
    total_len = data_len + divisor_len - 1;
    for (int i = data_len; i < total_len; i++)
    {
        data[i] = 0;
    }

    // Copy data to temp for division
    for (int i = 0; i < total_len; i++)
    {
        temp[i] = data[i];
    }

    // Perform division
    for (int i = 0; i < data_len; i++)
    {
        if (temp[i] == 1)
        {
            // Do XOR with divisor
            for (int j = 0; j < divisor_len; j++)
            {
                temp[i + j] = temp[i + j] ^ divisor[j];
            }
        }
    }

    // Copy remainder
    for (int i = 0; i < divisor_len - 1; i++)
    {
        remainder[i] = temp[data_len + i];
    }

    // Display results
    printf("\nCRC Remainder: ");
    for (int i = 0; i < divisor_len - 1; i++)
    {
        printf("%d", remainder[i]);
    }

    printf("\nFinal Transmitted Codeword: ");
    for (int i = 0; i < data_len; i++)
    {
        printf("%d", data[i]);
    }
    for (int i = 0; i < divisor_len - 1; i++)
    {
        printf("%d", remainder[i]);
    }

    printf("\n");

    return 0;
}
