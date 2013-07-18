// Copyright Hugh Perkins 2013
// You can use this under the Mozilla Public License 2.0

import org.apache.tools.ant.*;
import java.util.*;

public class SimpleAntAssert extends Task {

    public static class AssertEquals extends Task {
    String expected;
    String actual;
    public void setExpected( String expected ) {
        this.expected = expected;
    }
    public void setActual( String actual ) {
        this.actual = actual;
    }
    public void execute() throws BuildException {
        if( expected == null ) {
            throw new BuildException("'expected' value not supplied");
        }
        if( actual == null ) {
            throw new BuildException("'actual' value not supplied");
        }
        if( !expected.equals(actual ) ) {
             throw new BuildException("Assert failed.  Expected: " + expected + ". Actual: " + actual );
        }
    }
    }

    public static class AssertThrows implements TaskContainer {
        ArrayList<Task> children = new ArrayList<Task>();
        public void addTask( Task task ) {
            children.add(task);
        }
        public void execute() throws BuildException {
            boolean threwexception = false;
            try {
            for( Task child : children ) {
                child.perform();
            }
            } catch( BuildException e ) {
                threwexception = true;
            }
            if( !threwexception ) {
                throw new BuildException("BuildException required to be thrown, but none was.");
            }
        }
    }

    public void execute() throws BuildException {
        getProject().addTaskDefinition("assertequals", AssertEquals.class );
        getProject().addTaskDefinition("assertthrows", AssertThrows.class );
    }
}
