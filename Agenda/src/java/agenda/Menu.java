/*
 * $Id: HelloWorld.template,v 1.2 2008-03-27 05:47:21 ub3rsold4t Exp $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package agenda;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;

/**
 * <code>Set welcome message.</code>
 */
public class Menu extends ActionSupport {
    
 private String nombre;
 private String email; 
 private String telCasa;
 private String telCel;
 private String nota;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

 
 
    public String execute() throws Exception {
        setMessage(getText(MESSAGE));
        return SUCCESS;
    }

    /**
     * Provide default valuie for Message property.
     */
    public static final String MESSAGE = "HelloWorld.message";

    /**
     * Field for Message property.
     */
    private String message;

    /**
     * Return Message property.
     *
     * @return Message property
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Message property.
     *
     * @param message Text to display on HelloWorld page.
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public String guardarContacto() throws SQLException{
        Contacto c= new Contacto();
             c.setNombre(nombre);
             c.setEmail(email);
             c.setTelCasa(telCasa);
             c.setTelCel(telCel);
             c.setNota(nota);
             c.guardar();
        return SUCCESS;
    }
    
}

