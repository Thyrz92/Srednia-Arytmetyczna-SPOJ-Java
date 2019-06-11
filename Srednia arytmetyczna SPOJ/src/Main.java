import java.util.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Liczba implements Comparable<Liczba>
{
    private int liczba;
    private float bezwzgledna;

    public Liczba(){

    }

    public Liczba(int liczba, float bezwzgledna)
    {
        this.liczba = liczba;
        this.bezwzgledna = bezwzgledna;
    }

    public int getLiczba()
    {
        return liczba;
    }

    public float getBezwzgledna()
    {
        return bezwzgledna;
    }

    public int compareTo(Liczba o)
    {
        return Float.compare(this.bezwzgledna, o.bezwzgledna);
    }
}

public class Main
{
    public static Scanner wpisz = new Scanner(System.in);

    public static void fillList(List<Liczba> noweLiczby)
    {
        int ileLiczb = wpisz.nextInt();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < ileLiczb; i++)
        {
            int x = wpisz.nextInt();
            temp.add(x);
        }
        float suma = temp.stream().mapToInt(Integer::intValue).sum();
        int rozmiar = temp.size();
        float srednia = suma / rozmiar;

        for (int j = 0; j < temp.size(); j++)
        {
            int liczbav = temp.get(j);
            float bezwzgledna = Math.abs(srednia-liczbav);
            noweLiczby.add(new Liczba(liczbav, bezwzgledna));
        }
    }

    public static void main (String args[])
    {
        try
        {
            int ile = wpisz.nextInt();

            for (int k = 0; k < ile; k++) {
                List<Liczba> liczby = new ArrayList<>();
                fillList(liczby);

                Collections.sort(liczby);

                System.out.println(liczby.get(0).getLiczba());
            }
        }
        finally
        {
            return;
        }
    }
}
