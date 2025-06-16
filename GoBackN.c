#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int nf, N;
    int tr = 0;        // Total transmissions
    srand(time(NULL)); // Seed random number generator

    printf("Enter the number of frames: ");
    scanf("%d", &nf);

    printf("Enter the Window Size: ");
    scanf("%d", &N);

    int i = 1;

    while (i <= nf)
    {
        int acknowledged = 0;
        int frame_end = (i + N - 1 <= nf) ? (i + N - 1) : nf;

        // Send frames in window
        for (int j = i; j <= frame_end; j++)
        {
            printf("Sent Frame %d\n", j);
            tr++;
        }

        // Acknowledge frames
        for (int j = i; j <= frame_end; j++)
        {
            int flag = rand() % 2;

            if (flag == 0)
            {
                printf("Frame %d : Acknowledged!\n", j);
                acknowledged++;
            }
            else
            {
                printf("Frame %d : Not Acknowledged! (Simulated Loss)\n", j);
                printf("Retransmitting window from Frame %d...\n", j);
                break; // Go-Back-N: retransmit from this frame onward
            }
        }

        printf("\n");

        // Move window forward only by acknowledged frames (in-order)
        i += acknowledged;
    }

    printf("Total number of transmissions: %d\n", tr);
    return 0;
}