#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
int main() {
    pid_t apid, bpid;
    apid = fork();
    if (apid < 0)
        printf("error!");
    else if (apid == 0)
        printf("B,pid:%d,ppid:%d\n", getpid(), getppid());
    else if (apid > 0) {
        printf("A,pid:%d,ppid:%d\n", getpid(), getppid());
        bpid = fork();
        if (bpid < 0)
            printf("error!");
        else if (bpid == 0)
            printf("C,pid:%d,ppid:%d\n", getpid(), getppid());
    }
    waitpid(apid, NULL, 0);
    waitpid(bpid, NULL, 0);
    return 0;
}
