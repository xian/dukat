import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    ClassSuite::class,
    TopLevelMembersSuite::class
)
class MinimalTestSuite