import pandas as pd
import numpy as np
import powerlaw
import matplotlib.pyplot as plt


caminho = r'C:\Users\55859\Downloads\Trabalho Grafos V2 - Sem duplicatas\distribuicao_final_bruto.csv'

try:
    
    df = pd.read_csv(caminho)
    
    dados = np.repeat(df['k'].values, df['freq'].values)
    
    fit = powerlaw.Fit(dados, discrete=True)

    print("\n" + "="*40)
    print("MÉTODO CLAUSETH")
    print("="*40)
    print(f"Gamma (Alpha): {fit.alpha:.4f}")                            
    print(f"Xmin (Início da cauda): {fit.xmin:.4f}")                   
    print(f"Distância KS (D): {fit.D:.4f}")                             
    print(f"Erro Padrão: {fit.sigma:.4f}")                              
    
    # Comparação de Distribuições
    R, p = fit.distribution_compare('power_law', 'lognormal')
    print(f"Razão de Verossimilhança: {R}, Valor-p: {p}")         


except Exception as e:
    print(f"Erro ao processar: {e}")
    
    
try:
    plt.figure(figsize=(8, 6))
    fit.plot_ccdf(color='b', linewidth=2, label='Dados Reais')
    fit.power_law.plot_ccdf(color='r', linestyle='--', ax=plt.gca(), label='Ajuste Power Law')
    fit.lognormal.plot_ccdf(color='g', linestyle='-', ax=plt.gca(), label='Ajuste Log-normal')

    plt.xscale('log')
    plt.yscale('log')
    
    plt.title("Análise de Distribuição: CCDF Log-Log")
    plt.xlabel("Grau (k)")
    plt.ylabel("Probabilidade P(k)")
    plt.legend()
    plt.grid(True, which="both", ls="-", alpha=0.2) 

    plt.show()
    
    
    
except Exception as e:
    print(f"Erro ao processar plot: {e}")