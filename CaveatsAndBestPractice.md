### Best Practices (or positive considerations) ###
  * An alternative style promotes the use of domain-specific interfaces.
  * You can avoid the performance problem and the object’s dependency on Spring using domain interface-based DI.
  * **Dependency distribution pattern**. You inject the aspect with dependencies and the aspect will distribute those dependencies into other objects.

### Caveats ###
  * `@Configurable`-based DI uses reflection to inject all dependencies. For objects that are created often, this may cause a performance problem.