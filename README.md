simpleantassert
===============

simple ant assert. provides assertequals and assertthrows tasks

The advantage of this compared to the original antunit is that the asserteequals task is quite simple to use, doesn't need nested conditionals and so on.

Example usage
=============

	<project default="test">
		<target name="test">
			<taskdef name="simpleantassert" classname="SimpleAntAssert" classpath="../jar/simpleantassert.jar" />
			<simpleantassert />

			<assertequals expected="foo" actual="foo" />
        </target>
	</project>

First, we add simpleantassert to the build file, by using 'taskdef' followed by adding the simpleantassert tag.  Once we've done that, then we can freely use assertequals,
and assertthrows.

assertequals take two attributes: expected, and actual.  They must be identical, otherwise a BuildException will be thrown, containing the value of each attribute.
	
	<project default="test">
		<target name="test">
			<taskdef name="simpleantassert" classname="SimpleAntAssert" classpath="../jar/simpleantassert.jar" />
			<simpleantassert />

			<assertthrows>
				<fail message="check assertthrows" />
			</assertthrows>
		</target>
	</project>

assertthrows will throw a BuildException if no nested task throws a BuildException.

License
=======

Mozilla Public License 2.0
