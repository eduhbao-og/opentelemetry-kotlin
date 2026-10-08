package io.opentelemetry.kotlin.tracing.sampling

internal data class RemoteSamplingStrategy(
    val rateLimitingSampling: RateLimitingSamplingStrategy? = null,
    val probabilisticSampling: ProbabilisticSamplingStrategy? = null,
    val operationSampling: PerOperationSamplingStrategies? = null,
)

internal data class PerOperationSamplingStrategies(
    val defaultSamplingProbability: Double? = null,
    val defaultLowerBoundTracesPerSecond: Double? = null,
    val defaultUpperBoundTracesPerSecond: Double? = null,
    val perOperationStrategies: List<OperationSamplingStrategy> = emptyList(),
)

internal data class OperationSamplingStrategy(
    val operation: String,
    val probabilisticSampling: ProbabilisticSamplingStrategy? = null,
)

internal data class ProbabilisticSamplingStrategy(
    val samplingRate: Double? = null,
)

internal data class RateLimitingSamplingStrategy(
    val maxTracesPerSecond: Int? = null,
)