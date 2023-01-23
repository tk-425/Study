package com.springdemo.n01springbasic.n03_xml;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class XmlPersonDAO {

  XmlJdbcConnection xmlJdbcConnection;

  public void setXmlJdbcConnection(XmlJdbcConnection xmlJdbcConnection) {
    this.xmlJdbcConnection = xmlJdbcConnection;
  }

  public XmlJdbcConnection getXmlJdbcConnection() {
    return xmlJdbcConnection;
  }
}
