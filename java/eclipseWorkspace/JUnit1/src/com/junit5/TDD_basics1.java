package com.junit5;

public class TDD_basics1
{
	public String rev(String s)
	{
		String ns="";
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			ns=ch+ns;
		}
		return ns;
	}
}
