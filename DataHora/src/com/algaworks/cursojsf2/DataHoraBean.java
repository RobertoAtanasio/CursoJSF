package com.algaworks.cursojsf2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DataHoraBean {

	private List<String> consulta;
	
	public DataHoraBean() {
		this.consulta = new ArrayList<String>();
	}

	public List<String> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<String> consulta) {
		this.consulta = consulta;
	}

	public void limpar() {
		this.consulta.clear();
	}
	
	public void listarDatas() {
		
		//this.consulta = new ArrayList<String>();
		this.consulta.clear();
		
		Date data = new Date();
		this.consulta.add("Data Agora: " + data);
        System.out.println("Data Agora: " + data);
        //ex: Data Agora: Tue Aug 08 13:44:39 GFT 2017
        
        Date dataSQL;
        dataSQL = new Date(new java.util.Date().getTime());
        this.consulta.add("Data Agora: " + dataSQL);
        System.out.println("Data Agora: " + dataSQL);
        //ex: Data Agora: Wed Aug 23 21:43:57 BRT 2017
        
        //=== Recuperação da data com a classe Calendar
        //import java.util.Calendar;
        Calendar c = Calendar.getInstance();
        this.consulta.add("Data e Hora atual: " + c.getTime());
        System.out.println("Data e Hora atual: " + c.getTime());
        //ex: Data e Hora atual: Tue Aug 08 13:46:52 GFT 2017
        
        //=== Mostra o dia da semana, mês e ano
        //import java.util.Calendar;
        
        this.consulta.add("Data/Hora atual: " + c.getTime());
        this.consulta.add("Ano: " + c.get(Calendar.YEAR));
        this.consulta.add("Mês: " + c.get(Calendar.MONTH));
        this.consulta.add("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("Data/Hora atual: " + c.getTime());
        System.out.println("Ano: " + c.get(Calendar.YEAR));
        System.out.println("Mês: " + c.get(Calendar.MONTH));
        System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
        /*
        Data/Hora atual: Tue Aug 08 13:50:33 GFT 2017
        Ano: 2017
        Mês: 7
        Dia do Mês: 8
        */
        
        //=== Alterando a data/hora com método set
        //import java.util.Calendar;
        c.set(Calendar.YEAR, 1995); 
        c.set(Calendar.MONTH, Calendar.MARCH); 
        c.set(Calendar.DAY_OF_MONTH, 20);
        
        this.consulta.add("Data/Hora atual: "+c.getTime());
        this.consulta.add("Ano: " + c.get(Calendar.YEAR));
        this.consulta.add("Mês: " + c.get(Calendar.MONTH));
        this.consulta.add("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
        
        System.out.println("Data/Hora atual: "+c.getTime());
        System.out.println("Ano: " + c.get(Calendar.YEAR));
        System.out.println("Mês: " + c.get(Calendar.MONTH));
        System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
        /*
        Data/Hora atual: Mon Mar 20 13:49:40 GFT 1995
        Ano: 1995
        Mês: 2
        Dia do Mês: 20
        */
        
        //=== mostra-se como recuperar a hora do dia, fazendo uma interação 
        //    com o usuário informando uma mensagem de boas vindas.
        //import java.util.Calendar;
        int hora = c.get(Calendar.HOUR_OF_DAY);
        if(hora > 6 && hora < 12){
        	this.consulta.add("Bom Dia");
            System.out.println("Bom Dia");
        }else if(hora > 12 && hora < 18){
        	this.consulta.add("Boa Tarde");
            System.out.println("Boa Tarde");
        }else{
        	this.consulta.add("Boa Noite");
            System.out.println("Boa Noite");
        }
        
        //=== DateFormat
        /*
        import java.util.Calendar;
        import java.text.DateFormat;
        import java.util.Date;
        */
        c.set(2013, Calendar.FEBRUARY, 28);
		Date data2 = c.getTime();
		this.consulta.add("Data atual sem formatação: " + data2);
		System.out.println("Data atual sem formatação: " + data2);
		//Formata a data
		DateFormat formataData = DateFormat.getDateInstance();
		this.consulta.add("Data atual com formatação: " + formataData.format(data));
		System.out.println("Data atual com formatação: " + formataData.format(data));
		//Formata Hora
	    DateFormat hora2 = DateFormat.getTimeInstance();
	    this.consulta.add("Hora formatada: " + hora2.format(data2));
		System.out.println("Hora formatada: " + hora2.format(data2));
		//Formata Data e Hora
		DateFormat dtHora = DateFormat.getDateTimeInstance();
		this.consulta.add(dtHora.format(data));
		System.out.println(dtHora.format(data));
        /*
        Data atual sem formatação: Thu Feb 28 13:54:51 GFT 2013
        Data atual com formatação: 08/08/2017
        Hora formatada: 13:54:51
        08/08/2017 13:54:51
        */
        
        //=== Formatando data atual
        /*
        import java.util.Calendar;
        import java.text.DateFormat;
        import java.util.Date;
        */
        Date data3 = c.getTime();
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL); //Data COmpleta
        this.consulta.add("Data brasileira: " + f.format(data3));
        System.out.println("Data brasileira: " + f.format(data3));
        
        f = DateFormat.getDateInstance(DateFormat.LONG);
        this.consulta.add("Data sem o dia descrito: " + f.format(data3));
        System.out.println("Data sem o dia descrito: " + f.format(data3));
        
        f = DateFormat.getDateInstance(DateFormat.MEDIUM);
        this.consulta.add("Data resumida 1: " + f.format(data3));
        System.out.println("Data resumida 1: " + f.format(data3));
        
        f = DateFormat.getDateInstance(DateFormat.SHORT);
        this.consulta.add("Data resumida 2: " + f.format(data3));
        System.out.println("Data resumida 2: " + f.format(data3));
        /*
        Data brasileira: Quinta-feira, 28 de Fevereiro de 2013
        Data sem o dia descrito: 28 de Fevereiro de 2013
        Data resumida 1: 28/02/2013
        Data resumida 2: 28/02/13
        */
        
        //=== Conversões de Datas
        /*
        import java.util.Calendar;
        import java.text.DateFormat;
        import java.util.Date;
        import java.text.SimpleDateFormat;
        import java.text.ParseException;
        */
        Date data4 = c.getTime();
        DateFormat f2 = DateFormat.getDateInstance();
        Date data5;
		try {
			data5 = f2.parse("12/01/1995");
			this.consulta.add(data5.toString());
			System.out.println(data5);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        	this.consulta.add("Data formatada: " + sdf.format(data4));
            System.out.println("Data formatada: " + sdf.format(data4));
            //Converte Objetos
            this.consulta.add("Data convertida: " + sdf.parse("02/08/1970"));
			System.out.println("Data convertida: " + sdf.parse("02/08/1970"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /*
        Thu Jan 12 00:00:00 GFT 1995
        Data formatada: 28/02/2013
        Data convertida: Sun Aug 02 00:00:00 GFT 1970
        */
        
        //=== Internacionalização das datas
        /*
        import java.util.Calendar;
        import java.util.Locale;
        import java.text.DateFormat;
        import java.text.ParseException;
        import java.util.Date;
        */
        Calendar c2 = Calendar.getInstance();
        Date data6 = c2.getTime();
        Locale brasil = new Locale("pt", "BR"); //Retorna do país e a língua
        Locale eua = Locale.US;
        Locale italia = Locale.ITALIAN;

        DateFormat f2a = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        this.consulta.add("Data e hora brasileira: " + f2a.format(data6));
        System.out.println("Data e hora brasileira: " + f2a.format(data6));
        
        DateFormat f3a = DateFormat.getDateInstance(DateFormat.FULL, eua);
        this.consulta.add("Data e hora americana: " + f3a.format(data6));
        System.out.println("Data e hora americana: " + f3a.format(data6));
        
        DateFormat f4a = DateFormat.getDateInstance(DateFormat.FULL, italia);
        this.consulta.add("Data e hora italiana: " + f4a.format(data6));
        System.out.println("Data e hora italiana: " + f4a.format(data6));
        /*
        Data e hora brasileira: Terça-feira, 8 de Agosto de 2017
        Data e hora americana: Tuesday, August 8, 2017
        Data e hora italiana: martedì 8 agosto 2017
        */
		
	}
	
}
