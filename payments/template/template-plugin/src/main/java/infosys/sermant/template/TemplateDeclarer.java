package infosys.sermant.template;

import infosys.sermant.core.plugin.agent.declarer.AbstractPluginDeclarer;
import infosys.sermant.core.plugin.agent.declarer.InterceptDeclarer;
import infosys.sermant.core.plugin.agent.entity.ExecuteContext;
import infosys.sermant.core.plugin.agent.interceptor.Interceptor;
import infosys.sermant.core.plugin.agent.matcher.ClassMatcher;
import infosys.sermant.core.plugin.agent.matcher.MethodMatcher;

/**
 * 模板字节码增强声明
 *
 * @author luanwenfei
 * @since 2023-01-15
 */
public class TemplateDeclarer extends AbstractPluginDeclarer {
    @Override
    public ClassMatcher getClassMatcher() {
        return ClassMatcher.nameEquals("infosys.template.Application");
    }

    @Override
    public InterceptDeclarer[] getInterceptDeclarers(ClassLoader classLoader) {
        return new InterceptDeclarer[]{
                InterceptDeclarer.build(MethodMatcher.nameEquals("main"), new Interceptor() {
                    @Override
                    public ExecuteContext before(ExecuteContext context) throws Exception {
                        System.out.println("Good morning!");
                        return context;
                    }

                    @Override
                    public ExecuteContext after(ExecuteContext context) throws Exception {
                        System.out.println("Good night!");
                        return context;
                    }

                    @Override
                    public ExecuteContext onThrow(ExecuteContext context) throws Exception {
                        return context;
                    }
                })
        };
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }
}
