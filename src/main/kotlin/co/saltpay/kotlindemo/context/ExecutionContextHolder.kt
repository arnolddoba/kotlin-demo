package co.saltpay.kotlindemo.context

import org.jetbrains.annotations.NotNull

val THREAD_LOCAL: InheritableThreadLocal<ExecutionContext> = InheritableThreadLocal();

fun setExecutionContext(@NotNull executionContext: ExecutionContext?) {
    THREAD_LOCAL.set(executionContext)
}

fun getExecutionContext(): ExecutionContext {
    return THREAD_LOCAL.get();
}
