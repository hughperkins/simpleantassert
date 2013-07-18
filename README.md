simpleantassert
===============

simple ant assert. provides assertequals and assertthrows tasks

Example usage
=============

	<project default="test">
		<target name="test">
		    <!-- add simpleantassert to build file -->
			<taskdef name="simpleantassert" classname="SimpleAntAssert" classpath="../jar/simpleantassert.jar" />
			<simpleantassert />

			<!-- example of using assertequals -->
			<assertequals expected="foo" actual="foo" />

			<!-- example of using assertthrows: nested fail task throws BuildException, so assertthrows succeeds -->
			<assertthrows>
				<fail message="check assertthrows" />
			</assertthrows>

			<!-- example of using assertthrows: nested assertequals task throws BuildException, so assertthrows succeeds -->
			<assertthrows >
				<assertequals expected="foo" actual="blah" />
			</assertthrows>

			<!-- example of using assertthrows: nested assertthrows task throws BuildException, so assertthrows succeeds -->
			<assertthrows >
				<assertthrows />
			</assertthrows>
		</target>
	</project>

First, we add simpleantassert to the build file, by using 'taskdef' followed by adding the simpleantassert tag.  Once we've done that, then we can freely use assertequals,
and assertthrows.

assertequals take two attributes: expected, and actual.  They must be identical, otherwise a BuildException will be thrown, containing the value of each attribute.

assertthrows will throw a BuildException if the nested tasks do not throw a BuildException.

License
=======

Mozilla Public License 2.0
