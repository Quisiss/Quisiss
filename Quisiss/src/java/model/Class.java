/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo-Y50
 */
@Entity
@Table(name = "CLASS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Class.findAll", query = "SELECT c FROM Class c")
    , @NamedQuery(name = "Class.findByClassid", query = "SELECT c FROM Class c WHERE c.classid = :classid")
    , @NamedQuery(name = "Class.findByClassname", query = "SELECT c FROM Class c WHERE c.classname = :classname")
    , @NamedQuery(name = "Class.findByClasscode", query = "SELECT c FROM Class c WHERE c.classcode = :classcode")
    , @NamedQuery(name = "Class.findByOwnerid", query = "SELECT c FROM Class c WHERE c.ownerid = :ownerid")})
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLASSID")
    private Integer classid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CLASSNAME")
    private String classname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "CLASSCODE")
    private String classcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OWNERID")
    private int ownerid;

    public Class() {
        Class c = new Class(1);
    }

    public Class(Integer classid) {
        this.classid = classid;
    }

    public Class(Integer classid, String classname, String classcode, int ownerid) {
        this.classid = classid;
        this.classname = classname;
        this.classcode = classcode;
        this.ownerid = ownerid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classid != null ? classid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Class)) {
            return false;
        }
        Class other = (Class) object;
        if ((this.classid == null && other.classid != null) || (this.classid != null && !this.classid.equals(other.classid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Class[ classid=" + classid + " ]";
    }
    
}
