package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Flow implements Comparable<Flow>
{

	private LocalDate day;
	private double flow;
	private River river;

	public Flow(LocalDate day, double flow, River river)
	{
		this.day = day;
		this.flow = flow;
		this.river = river;
	}

	public LocalDate getDay() 
	{
		return day;
	}

	public void setDay(LocalDate day) 
	{
		this.day = day;
	}

	public double getFlow() 
	{
		return flow;
	}

	public void setFlow(double flow)
	{
		this.flow = flow;
	}
	

	public River getRiver() 
	{
		return river;
	}

	@Override
	public String toString()
	{
		return "Flow [day=" + day + ", flow=" + flow + ", river=" + river + "]";
	}

	@Override
	public int compareTo(Flow o)
	{
		if(this.getDay().isAfter(o.getDay()))
		{
			return 1;
		}
		else if(this.getDay().isBefore(o.getDay()))
			return -1;
		else
			return 0;
	}

}
