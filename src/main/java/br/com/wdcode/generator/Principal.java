package br.com.wdcode.generator;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Principal {

	public static void main(String[] args) throws Exception{
		Cliente cliente = new Cliente("Fernando", "fernando@exemplo.com", 19);
		Cliente cliente1 = new Cliente("Fernando", "fernando@exemplo.com", 33);
		Cliente cliente2 = new Cliente("Fernando", "fernando@exemplo.com", 89);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente);
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		XStream stream = new XStream(new DomDriver());
		stream.alias("cliente", Cliente.class);
		String clientexml = stream.toXML(clientes);
		
		try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("clientes.xml"))){
			writer.write(clientexml);
		}
		
		System.out.println(clientexml);
	}

}
