package td1;

/**
* td1/HorlogeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Horloge.idl
* lundi 7 f�vrier 2005 23 h 30 CET
*/

public final class HorlogeHolder implements org.omg.CORBA.portable.Streamable
{
  public td1.Horloge value = null;

  public HorlogeHolder ()
  {
  }

  public HorlogeHolder (td1.Horloge initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = td1.HorlogeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    td1.HorlogeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return td1.HorlogeHelper.type ();
  }

}
