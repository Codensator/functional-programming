/**     03 - OOP
 *
 */


package com.amigoscode;

/**     04 - @FunctionalInterface
 *      Wenn man der Methode @FunctionalInterface voranstellt, dann wird diese als Interface für eine function gekennzeichnet.
 *      Dem interface kann somit keine zweite Methode hinzugefügt werden, sodass kein Fehler beim Aufruf mit einer function auftritt.
 *      FunctionalInterface enthält immer eine einzige abstrakte Methode.
 */
@FunctionalInterface // 04 - @FunctionalInterface
public interface EmailSender
{
    void send();
    //void unSend(); // 04 - @FunctionalInterface
}
