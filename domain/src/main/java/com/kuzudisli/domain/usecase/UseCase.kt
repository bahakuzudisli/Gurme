package com.kuzudisli.domain.usecase

interface UseCase<in Parameter, out Result> {
    suspend operator fun invoke(params: Parameter): Result
}