import java.util.Scanner;

class Products
{
    private int id;
    private String name;
    private float price;
    private int count;

    public void setId(int id)
    {
        this.id=id;
    }
    public int getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public void setPrice(float price)
    {
        this.price=price;
    }
    public Float getPrice()
    {
        return price;
    }
    public void setCount(int count)
    {
        this.count=count;
    }
    public int getCount()
    {
        return count;
    }

    
}
class Sections
{
    private int section_number;
    private String section_name;
    private Products pp[];


    public void setSection_Number(int section_number)
    {
        this.section_number=section_number;
    }
    public int getSection_Number()
    {
        return section_number;
    }
    public void setSection_name(String section_name)
    {
        this.section_name=section_name;
    }
    public String getSection_name()
    {
        return section_name;
    }
    void setProducts(Products p[])
    {
        this.pp=p;
    }
    Products [] getProducts()
    {
        return pp;
    }

}
class Dmart
{
    private String d_name;
    private String d_address;
    private Sections sc[];
;    public void setd_name(String d_name)
    {
        this.d_name=d_name;
    }
    public String getd_name()
    {
        return d_name;
    }
    public void setd_address(String d_address)
    {
        this.d_address=d_address;
    }
    public String getd_address()
    {
        return d_address;
    }
    void setSectionsInDmart(Sections[]sc)
    {
        this.sc=sc;
    }
    Sections[] getSectionsInDmart()
    {
        return sc;
    }
    void displayProductsBySectionNumber(int section_number)
    {
        for(int i=0;i<sc.length;i++)
        {
            if(sc[i].getSection_Number()==section_number)
            {
                Products prod[]=sc[i].getProducts();
                System.out.println("Product list in that section");
                System.out.println("Product Id \t name \t Price \t count");
                for(int j=0;j<prod.length;j++)
                {
                    System.out.println(prod[j].getId()+"\t"+prod[j].getName()+"\t"+prod[j].getPrice()+"\t"+prod[j].getCount());
                }
            }
            
        }
    }
    void display()
    {
        System.out.println("Dmart Information");
        System.out.println("*************************************************************");
        System.out.println("Dmart Name \t address");
        System.out.println(getd_name()+"\t"+getd_address());
        System.out.println("_____________________________________________________________");
        for(int i=0;i<sc.length;i++)
        {
            System.out.println("SectionNumber\tSectionName \t ");
            System.out.println(sc[i].getSection_Number()+"\t"+sc[i].getSection_name());
            System.out.println("____________________________________________________________");
            Products prod[]=sc[i].getProducts();
            for(int j=0;j<prod.length;j++)
            {
                System.out.println("ProductId \t Name \t Price\t Count");
                System.out.println("_________________________________________________________");
                System.out.println(prod[j].getId()+"\t"+prod[j].getName()+"\t"+prod[j].getPrice()+"\t"+prod[j].getCount());
            }
        }
    }
    void getCountOfProductsInSections()
    {
        int count = 0;
        for(int i=0;i<sc.length;i++)
        {
            Products prod[]=sc[i].getProducts();
            count=0;
            for(int j=0;j<prod.length;j++)
            {
                count++;
            }
            System.out.println("Count of products in sectionnumber "+sc[i].getSection_Number()+" and section name:"+sc[i].getSection_name()+"="+count);
        }
    } 
    void totalCountOfProducts()
    {
        int count = 0;
        for(int i=0;i<sc.length;i++)
        {
            Products prod[]=sc[i].getProducts();
            for(int j=0;j<prod.length;j++)
            {
                count++;
            }
        }
        System.out.println("Total count of all products in dmart:"+count);
    }
    void searchProductById(int id)
    {
        for(int i=0;i<sc.length;i++)
        {
            Products prod[]=sc[i].getProducts();
            for(int j=0;j<prod.length;j++)
            {
                if(prod[j].getId()==id)
                {
                    System.out.println(sc[i].getSection_Number()+"\t"+sc[i].getSection_name());
                    System.out.println(prod[j].getId()+"\t"+prod[j].getName()+"\t"+prod[j].getPrice()+"\t"+prod[j].getCount());
                }
                else
                {
                    System.out.println("Product not found in dmart");
                }
            }
        }
    }
    
}
public class DmartManagementApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dmart d1=new Dmart();
        System.out.println("Enter dmart name:");
        String d_name=sc.nextLine();
        System.out.println("Enter dmart address:");
        String d_address=sc.nextLine();

        d1.setd_name(d_name);
        d1.setd_address(d_address);

        System.out.println("Enter no of sections in dmart");
        int no_of_sections=sc.nextInt();
        Sections s1[]=new Sections[no_of_sections];

        for(int i=0;i<s1.length;i++)
        {
            System.out.println("Enter section number and name:");
            int section_number=sc.nextInt();
            String section_name=sc.nextLine();


            System.out.println("Enter no of products:");
            int no_of_products=sc.nextInt();
            Products p1[]=new Products[no_of_products];

            for(int j=0;j<p1.length;j++)
            {
                System.out.println("Enter Product id,name,price and count:");
                int id=sc.nextInt();
                sc.nextLine();
                String name=sc.nextLine();
                Float price=sc.nextFloat();
                int count=sc.nextInt();

                p1[j]=new Products();
                p1[j].setId(id);
                p1[j].setName(name);
                p1[j].setPrice(price);
                p1[j].setCount(count);
            }

            s1[i]=new Sections();
            s1[i].setSection_Number(section_number);
            s1[i].setSection_name(section_name);
            s1[i].setProducts(p1);
        }
        d1.setSectionsInDmart(s1);
        d1.display();
        d1.getCountOfProductsInSections();
        d1.totalCountOfProducts();

        System.out.println("Enter Product Id to be search:");
        int id=sc.nextInt();

        d1.searchProductById(id);

        System.out.println("Enter section number you want to see:");
        int s_num=sc.nextInt();

        d1.displayProductsBySectionNumber(s_num);
    }
}
